package com.jjc.ssoClient.web.controller;

import com.jjc.ssoClient.common.constants.UserConstants;
import com.jjc.ssoClient.web.util.VerifyCodeUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * 验证码
 * @author Administrator
 * v1.0
 */

@Controller
public class CodeController extends  BaseApiController {
	private Logger logger = Logger.getLogger(getClass());
	/**
	 * 默认生成图形二维码（128*41）
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/code" ,method = RequestMethod.GET)
	public void createCodeImg(HttpServletRequest request, HttpServletResponse response){
		response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
          
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session  
        HttpSession session = request.getSession(true);
        session.setAttribute(UserConstants.LOGIN_CODE, verifyCode.toLowerCase());

        //生成图片  
        int w = 128, h = 41;
        try {
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("生成验证码异常");
		}  
	}

	//检查验证码是否正确
	@RequestMapping("/checkCode")
	@ResponseBody
	public Object checkCode(String code ,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute(UserConstants.LOGIN_CODE);
		logger.info("SSO检查验证码--checkCode"+"- user:"+code + "--session" +sessionCode);
		if(null != sessionCode && null != code ){
			if(code.equalsIgnoreCase(sessionCode)){
				logger.info("成功");
				return  this.operateSuccess(null);
			}else{
				logger.info("失败");
				return  this.operateError("验证码错误");
			}
		}else{
			logger.info("参数错误");
			return  this.operateError("参数错误");
		}
	}

}
