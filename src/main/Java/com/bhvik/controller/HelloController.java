package com.bhvik.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HelloController {

    @RequestMapping(value = "/index",method=RequestMethod.GET)
    public ModelAndView index(HttpServletRequest req, HttpServletResponse res)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        HttpSession session = req.getSession(false);
        String user_session = (String)session.getAttribute("user_session");

        return new ModelAndView("index","user_session",user_session);
    }

    @RequestMapping("/hello")
    public ModelAndView helloWorld() throws UnknownHostException {

        String ip = Inet4Address.getLocalHost().getHostAddress();
        return new ModelAndView("hello", "ip", ip);
    }

}
