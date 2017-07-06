package com.abitty.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


/**
 * Created by kkk on 17/4/28.
 */
@Controller
public class IndexController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public ModelAndView index(final HttpSession httpSession, Model model) {

        String admin = (String) httpSession.getAttribute("admin");

        model.addAttribute("admin", admin);

        return new ModelAndView("index");
    }


}
