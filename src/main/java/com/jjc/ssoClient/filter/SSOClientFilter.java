package com.jjc.ssoClient.filter;

import com.baomidou.kisso.SSOConfig;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.Token;
import com.baomidou.kisso.common.SSOProperties;
import com.baomidou.kisso.common.util.HttpUtil;
import com.jjc.ssoClient.common.constants.UserConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by jiangjiacheng on 2017/7/18.
 */
public class SSOClientFilter implements Filter {
    private static final Logger logger = Logger.getLogger("SSOFilter");
    private static String OVERURL = null;

    public SSOClientFilter() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        OVERURL = config.getInitParameter("over.url");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        boolean isOver = HttpUtil.inContainURL(req, OVERURL);
        if(!isOver) {
            Token token = SSOHelper.getToken(req);

            System.out.println("---------JJC");
            System.out.println(token);
            System.out.println("---------JJC1111");

            if(token == null) {
                logger.fine("logout. request url:" + req.getRequestURL());
                SSOProperties prop = SSOConfig.getSSOProperties();
                String retStr = prop.get("sso.defined.proxyloginurl");
                res.sendRedirect(HttpUtil.encodeRetURL(prop.get("sso.login.url"), "ReturnURL", retStr));
                return;
            }else{
                req.setAttribute(SSOConfig.SSO_TOKEN_ATTR, token);
            }

            if(req.getSession().getAttribute(UserConstants.LOGIN_USER) == null){
                SSOHelper.logout(req,res);
                return ;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        OVERURL = null;
    }
    
}
