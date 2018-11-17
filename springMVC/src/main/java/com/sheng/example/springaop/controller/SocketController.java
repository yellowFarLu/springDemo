package com.sheng.example.springaop.controller;

import com.sheng.example.springaop.websocket.MyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author huangy
 * @date 2017/12/13
 */
@Controller
public class SocketController {

    @Resource
    MyHandler myHandler;


    @RequestMapping("/login/{userId}")
    public @ResponseBody String login(HttpSession session, @PathVariable("userId") Integer userId) {
        System.out.println("登录接口,userId="+userId);
        session.setAttribute("userId", userId);
        System.out.println(session.getAttribute("userId"));

        return "success";
    }

    @RequestMapping("/message")
    public @ResponseBody String sendMessage() {
        boolean hasSend = myHandler.sendMessageToUser(4, new TextMessage("发送一条消息"));
        System.out.println(hasSend);
        return "message";
    }

}
