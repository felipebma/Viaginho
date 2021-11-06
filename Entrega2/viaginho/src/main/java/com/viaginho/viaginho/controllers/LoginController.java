package com.viaginho.viaginho.controllers;

import javax.servlet.http.HttpSession;

import com.viaginho.viaginho.services.AccountService;
import com.viaginho.viaginho.Facade;
import com.viaginho.viaginho.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {// TODO: checar se devemo trocar o nome do login com o createSession 

    @Autowired
    Facade facade;

    @GetMapping("/")
    public ModelAndView login(HttpSession session) {
        ModelAndView mv = new ModelAndView("loginScreen");
        mv.addObject("account", new Account());
        if (session.getAttribute("account") != null) {
            mv.setViewName("mainScreen");
            mv.addObject("name", ((Account) session.getAttribute("account")).getName());
        }
        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("account");
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/")
    public ModelAndView createSession(HttpSession session, @ModelAttribute Account account) {// TODO: checar nomenclatura (esse deveria ser o login pois recebe o account (segundo o diagrama)?)
        ModelAndView mv = new ModelAndView("mainScreen");
             
        account = facade.login(account); 
        if (account == null) {
            return new ModelAndView("redirect:/");
        }
        
        session.setAttribute("account", account);
        mv.addObject("name", account.getName());
        return mv;
    }
}
