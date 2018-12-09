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
public class CookieController extends BaseController {

    @Resource
    private AOPService aopService;

    @ResponseBody
    @RequestMapping("/springcookie")
    public User springCookie(@ModelAttribute User model, HttpServletRequest request,
                             HttpServletResponse response) {
        // request.getContextPath()拿到的是你的web项目的根路径（tomcat中application context的值）
        LOGGER.info("request.contextPath={}", request.getContextPath());

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                LOGGER.info("request.cookie.Comment={}", cookie.getComment());
                LOGGER.info("request.cookie.Domain={}", cookie.getDomain());
                LOGGER.info("request.cookie.MaxAge={}", cookie.getMaxAge());
                LOGGER.info("request.cookie.Name={}", cookie.getName());
                LOGGER.info("request.cookie.Path={}", cookie.getPath());
                LOGGER.info("request.cookie.Secure={}", cookie.getSecure());
                LOGGER.info("request.cookie.Value={}", cookie.getValue());
                LOGGER.info("request.cookie.Version={}", cookie.getVersion());
            }
        } else {
            LOGGER.info("---------- not cookie");
        }

        Cookie cookie = new Cookie("MyCookie", "SESSIONID=1");
//        cookie.setPath("/web");
//        cookie.setMaxAge(0);
//        cookie.setSecure(true);
        cookie.setDomain("localhost");
        response.addCookie(cookie);

        LOGGER.info("response={}", response);

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
