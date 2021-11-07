package com.viaginho.viaginho.controllers;

import javax.servlet.http.HttpSession;

public class ControllerUtils {
    public static boolean hasActiveSession(HttpSession session){
        return session.getAttribute("account") != null;
    }
}
