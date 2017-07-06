package com.abitty.admin.controller;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yak on 17/6/17.
 */
@Controller
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login")
    public ModelAndView login(final String uname, final String passwd, Model model, HttpServletRequest httpServletRequest) {
        logger.info("用户登录请求 uname={} passwd={}", uname, passwd);

        if (Strings.isNullOrEmpty(uname) || Strings.isNullOrEmpty(passwd)
                || !"abitty".equals(uname) || !"abitty".equals(passwd)) {
            model.addAttribute("errorMsg", "用户名或密码错误!");
            return new ModelAndView("../../login");
        }

        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("admin", uname);

        logger.info("用户登录成功 admin={}", session.getAttribute("admin"));
        return new ModelAndView("index");
    }
}
