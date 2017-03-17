package com.bhvik.services;


import com.bhvik.utility.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckUser {

    private Connection connection;

    public CheckUser(){
        connection = DBUtility.getConnection();
    }

    public boolean checkUser(String email,String password){

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from users WHERE email=? AND password=?");
            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean checkEmail(String email){

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from users WHERE email=?");
            ps.setString(1,email);


            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
