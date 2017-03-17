package com.bhvik.controller;


import com.bhvik.services.CheckUser;
import com.bhvik.utility.DBUtility;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

@Controller
public class LoginController {

    private Connection connection;
    public LoginController()
    {
        connection = DBUtility.getConnection();
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView getSignIn(HttpSession session){

        String user_session = (String)session.getAttribute("user_session");

        if(user_session != null)
        {
            return new ModelAndView("index","message","<div class=\"alert alert-info\">you are already loggedin !!</div>");
        }
        else {
            return new ModelAndView("signin");
        }

    }


    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public ModelAndView postSignIn(HttpServletRequest req, HttpServletResponse res){

        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        if (new CheckUser().checkUser(email,pass))
        {
            HttpSession session = req.getSession();
            session.setAttribute("user_session", email);

            String message = "<div class=\"alert alert-success\">Success !!</div>";

            return new ModelAndView("index","message",message);
        }


        String message = "<div class=\"alert alert-danger\">Wrong Credentials!!!</div>";

        return new ModelAndView("signin","message",message);
    }

    @RequestMapping("/logout")
    public ModelAndView bhavik(HttpSession session){

        if((String)session.getAttribute("user_session") == null){
            return new ModelAndView("index");
        }
        else {

            session.invalidate();
            String message = "<div class=\"alert alert-info\">Logout successfull !!</div>";
            return new ModelAndView("index","message",message);
        }

    }

}
