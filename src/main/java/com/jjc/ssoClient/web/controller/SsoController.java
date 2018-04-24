package com.jjc.ssoClient.web.controller;

import com.baomidou.kisso.*;
import com.baomidou.kisso.common.SSOProperties;
import com.jjc.ssoClient.common.constants.UserConstants;
import com.jjc.ssoClient.service.KorCoreUserService;
import com.jjc.ssoClient.web.util.AjaxHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by jiangjiacheng on 2017/7/17.
 */

@Controller
public class SsoController {

    @Autowired
    private KorCoreUserService korCoreUserService;


    protected String redirectTo(String url) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }

    @RequestMapping("/")
    public String welcome(Model model, HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        return "redirect:/index";
    }


 @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        model.addAttribute("userId" , request.getSession().getAttribute(UserConstants.LOGIN_USER));
        model.addAttribute("list",korCoreUserService.demo());
        System.out.println(request.getSession().getAttribute(UserConstants.LOGIN_USER));
        return "/index";
    }


    /*
    *
         * 跨域登录
    */
    @RequestMapping("/proxylogin")
    public String proxylogin(Model model,HttpServletRequest request,HttpServletResponse response) {
       /*  *
         * 用户自定义配置获取
         *
         * <p>
         * 由于不确定性，kisso 提倡，用户自己定义配置。
         * </p>
         **/


        SSOProperties prop = SSOConfig.getSSOProperties();

        //业务系统私钥签名 authToken 自动设置临时会话 cookie 授权后自动销毁
        AuthToken at = SSOHelper.askCiphertext(request, response, prop.get("sso.defined.demo_private_key"));

        //at.getUuid() 作为 key 设置 authToken 至分布式缓存中，然后 sso 系统二次验证

        //askurl 询问 sso 是否登录地址
        model.addAttribute("askurl", prop.get("sso.defined.askurl"));

        //askTxt 询问 token 密文
        model.addAttribute("askData", at.encryptAuthToken());

        //my 确定是否登录地址
        model.addAttribute("okurl", prop.get("sso.defined.oklogin"));
        return "proxylogin";
    }

/*
*
     * 跨域登录成功*/
    @ResponseBody
    @RequestMapping("/oklogin")
    public void oklogin( HttpServletRequest request,HttpServletResponse response) {
        try {
              SSOProperties prop = SSOConfig.getSSOProperties();
            //String returl = prop.get("sso.defined.clientTimeout");
            String returl =prop.get("sso.logout.url");
          /*   * <p>
             * 回复密文是否存在
             * </p>
             * <p>
             * SSO 公钥验证回复密文是否正确
             * </p>
             * <p>
             * 设置 业务系统自己的 Cookie
             * </p>*/


            String replyTxt = request.getParameter("replyTxt");
            if (replyTxt != null && !"".equals(replyTxt)) {
                AuthToken at = SSOHelper.ok(request, response, replyTxt, prop.get("sso.defined.my_public_key"),prop.get("sso.defined.sso_public_key"));

                if (at != null) {
                    returl = prop.get("sso.defined.clientIndex");
                    SSOToken st = new SSOToken();
                    st.setUid(at.getUid());
                    st.setTime(at.getTime());
    //                st.setData(at.getData());
                     //* 设置 true 时添加 cookie 同时销毁当前 JSESSIONID 创建信任的 JSESSIONID

                    SSOHelper.setSSOCookie(request, response, st, true);

                    Token token = SSOHelper.getToken(request);

                    System.out.println("---------JJC");
                    System.out.println(token);
                    System.out.println("---------JJC1111");

                    request.getSession().setAttribute(UserConstants.LOGIN_USER,at.getUid());
                    //登录逻辑
                    /*korCoreUserService.login(Integer.parseInt(at.getUid()), request, response);*/

                }
            }
            AjaxHelper.outPrint(response, "{\"returl\":\"" + returl + "\"}", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/**
     * 跨域登录超时*/
    @RequestMapping("/timeout")
    public String timeout() {
        return "timeout";
    }


     /**
     * 如果实现 SSOCache 缓存， kisso 自动缓存 token 退出只需要 SSOHelper.clearLogin(request, response);
     *
     * 自动清理 token 缓存信息， 同时各个系统都会自动退出。 建议这么！！退出更优雅。。。
     *
     * --------------- 悲剧的开启 ---------------
     *
     * 如果你不这么干那么您只能挨个不同域退出一遍，最终全站退出。
     **/


    @RequestMapping("/logout")
    public String logout( HttpServletRequest request,HttpServletResponse response) throws IOException {
        /* * <p>
         * SSO 退出，清空退出状态即可
         * </p>
         *
         * <p>
         * 子系统退出 SSOHelper.logout(request, response); 注意 sso.properties 包含 退出到
         * SSO 的地址 ， 属性 sso.logout.url 的配置
         * </p>
*/

        SSOHelper.logout(request,response);
SSOHelper.clearLogin(request, response);

        return "";
    }

}
