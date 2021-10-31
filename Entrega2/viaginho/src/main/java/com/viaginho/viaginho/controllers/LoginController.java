package com.viaginho.viaginho.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/")
    public ModelAndView Login(HttpSession session) {
        ModelAndView mv = new ModelAndView("loginScreen");
        if (session.getAttribute("userEmail") != null) {
            mv.setViewName("mainScreen");
            mv.addObject("name", session.getAttribute("userEmail"));
        }
        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView Logout(HttpSession session) {
        ModelAndView mv = new ModelAndView("loginScreen");
        session.removeAttribute("userEmail");
        mv.addObject("name", "MV");
        return mv;
    }

    @PostMapping("/")
    public ModelAndView postRequest(HttpSession session, @RequestParam("email") String email,
            @RequestParam("password") String password) {
        ModelAndView mv = new ModelAndView("mainScreen");
        session.setAttribute("userEmail", email);
        mv.addObject("name", email);
        return mv;
    }
}
