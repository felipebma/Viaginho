package com.viaginho.viaginho.controllers;

import javax.servlet.http.HttpSession;

import com.viaginho.viaginho.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/")
    public ModelAndView Login(HttpSession session) {
        ModelAndView mv = new ModelAndView("loginScreen");
        mv.addObject("user", new User());
        if (session.getAttribute("userEmail") != null) {
            mv.setViewName("mainScreen");
            mv.addObject("name", session.getAttribute("userEmail"));
        }
        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView Logout(HttpSession session) {
        session.removeAttribute("userEmail");
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/")
    public ModelAndView createSession(HttpSession session, @ModelAttribute User user) {
        ModelAndView mv = new ModelAndView("mainScreen");
        session.setAttribute("user", user);
        mv.addObject("name", user.getEmail());
        return mv;
    }
}
