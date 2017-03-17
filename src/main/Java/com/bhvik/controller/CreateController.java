package com.bhvik.controller;


import com.bhvik.services.CheckUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bhvik.utility.DBUtility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CreateController {

    private Connection connection;

    public CreateController(){
        connection = DBUtility.getConnection();
    }


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView getSignUp(HttpSession session) {

        String user_session = (String)session.getAttribute("user_session");

        if(user_session != null)
        {
            return new ModelAndView("index","message","<div class=\"alert alert-info\">Please logout first!!</div>");
        }
        else {
            return new ModelAndView("signup");
        }

    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView postSignIn(HttpServletRequest req, HttpServletResponse res) throws UnknownHostException, ClassNotFoundException, SQLException {

        String fname = req.getParameter("firstname");
        String lname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String message = "";

        if (new CheckUser().checkEmail(email)){

            message = "<div class=\"alert alert-danger\">email already used!!</div>";

            return new ModelAndView("signup","message",message);

        }
        else {

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            try {

                PreparedStatement ps = connection.prepareStatement("INSERT INTO users (firstname,lastname,email,password,user_ip,signup_date) VALUES (?,?,?,?,?,?)");

                ps.setString(1, fname );
                ps.setString(2, lname);
                ps.setString(3, email);
                ps.setString(4, pass);
                ps.setString(5, Inet4Address.getLocalHost().getHostAddress());
                ps.setString(6, dateFormat.format(date));
                ps.executeUpdate();

                message = "<div class=\"alert alert-success\">Signup Successfull !!</div>";

            } catch (SQLException e) {

            }
        }

        return new ModelAndView("index", "message", message);
    }

    @RequestMapping(value = "/checkEmail",method = RequestMethod.POST)
    public int check(HttpServletRequest req,HttpServletResponse res){

        String email = req.getParameter("email");

        if(new CheckUser().checkEmail(email))
        {
            return 1;
        }
        return 0;
    }

}














