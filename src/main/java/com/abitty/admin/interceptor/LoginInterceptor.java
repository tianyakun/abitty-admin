package com.abitty.admin.interceptor;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yak on 17/6/17.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String requestUri = request.getRequestURI(); //请求完整路径，可用于登陆后跳转
        String contextPath = request.getContextPath();  //项目下完整路径
        String url = requestUri.substring(contextPath.length()); //请求页面

//        logger.info("登录拦截器处理请求: requestUri={}", requestUri);

        HttpSession session = request.getSession();

        String admin = (String)session.getAttribute("admin");

        if (requestUri.contains("login")) {
//            logger.info("登录行为, requestUri={}", requestUri);
            return true;
        } else if(!Strings.isNullOrEmpty(admin)){  //判断用户是否存在，不存在返回登录界面，继续拦截，存在通过拦截，放行到访问页面
//            logger.info("用户已登录, admin={}", admin);
            return true;
        } else {
            logger.info("用户未登录,普通请求拦截,跳转至登录页!");
            response.sendRedirect("/login.jsp");
//            request.getRequestDispatcher("/view/login").forward(request, response);//转发到登录界面
            return false;
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
