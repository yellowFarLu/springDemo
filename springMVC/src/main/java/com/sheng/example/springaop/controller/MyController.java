package com.sheng.example.springaop.controller;

import com.sheng.example.springaop.model.CustomerPersonalStatistics;
import com.sheng.example.springaop.model.Pager;
import com.sheng.example.springaop.model.User;
import com.sheng.example.springaop.model.result.AjaxResult;
import com.sheng.example.springaop.param.Test;
import com.sheng.example.springaop.service.AOPService;
import com.sheng.example.springaop.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

@Controller
public class MyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @Resource
    private TestService testService;

    @Autowired
    private AOPService aopService;

    @ResponseBody
    @RequestMapping("/springaop")
    public User springAop(@ModelAttribute User model){
        return model;
    }

    @ResponseBody
    @RequestMapping("/springaop/{username}")
    public  String springTemplate(@PathVariable String username) {
        return "springTemplate1111: " + username;
    }

    @RequestMapping("/springaop/redirect")
    public String springRedirect(Model model) {
        LOGGER.debug("springRedirect");

        /**
         * 1.model中的attribute会直接作为参数，添加到url后面
         * 2.如果重定向的url为模板url，把对应参数作为占位符，则会添加到url上
          */
        model.addAttribute("username", "huangy");


//        return "redirect:/springaop";
        return "redirect:/springaop/{username}";
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @ResponseBody
    @RequestMapping("/upload")
    public String uploadFile(@RequestParam(value = "file", required = false) MultipartFile uploadFile) {

        try {
            byte[] data = uploadFile.getBytes();

            System.out.println(data);

        } catch (IOException e) {
            LOGGER.error("upload file error ", e);
        }

        return "YES";
    }

    @RequestMapping(value="/uploadparam")
    @ResponseBody
    public String uploadParam(@RequestBody Pager pager, @RequestBody Test test) {

        LOGGER.info(test.toString());

        return "uploadparam";
    }

    @RequestMapping(value="/test")
    @ResponseBody
    public String testExcepition() {

        try {
            testService.test();
        } catch (Exception e) {
            LOGGER.error("testExcepition", e);
        }
        

        LOGGER.debug("能否继续运行");

        return "test";
    }

    @RequestMapping(value = "/test2")
    @ResponseBody
    public String testParam(String appId) {
        LOGGER.info("testParam : appId={}", appId);
        return appId;
    }

    @RequestMapping(value = "/test4")
    @ResponseBody
    public AjaxResult testExtend() {
        return new AjaxResult(new CustomerPersonalStatistics());
    }

    @ModelAttribute
    public User getModel() {
        User user = new User();
        user.setName("huangy model");
        user.setTest("Test");

        return user;
    }
}
