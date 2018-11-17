package com.controller;

import com.sheng.example.springaop.model.User;
import com.sheng.example.springaop.service.AOPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huangy on 2018/11/17
 */
@Controller
public class CookieController {

    @Resource
    private AOPService aopService;

    @ResponseBody
    @RequestMapping("/springcookie")
    public User springCookie(@ModelAttribute User model){
        return model;
    }

    @ModelAttribute
    public User getModel() {
        User user = new User();
        user.setName("huangy model");
        user.setTest("Test");

        return user;
    }
}
