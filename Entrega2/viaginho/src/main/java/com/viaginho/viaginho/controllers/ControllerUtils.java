package com.viaginho.viaginho.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.viaginho.viaginho.model.Account;

public class ControllerUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean hasActiveSession(HttpSession session){
        return session.getAttribute("account") != null;
    }
    public static String getUserEmail(HttpSession session){
        return ((Account)session.getAttribute("account")).getEmail();
    }
    public static String format(Date date){
        return sdf.format(date);
    }
    public static Date parse(String date){
        try{
            return sdf.parse(date);
        }catch(Exception e){}
        return null;
    }

    
    
}
