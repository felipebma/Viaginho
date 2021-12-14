package com.viaginho.viaginho.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.viaginho.viaginho.Facade;
import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.model.NewAccountDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    Facade facade;

    @GetMapping("/")
    public ModelAndView login(HttpSession session) {
        if (ControllerUtils.hasActiveSession(session)) {
            return new ModelAndView("mainScreen", "name", ((Account) session.getAttribute("account")).getName());
        }
        return new ModelAndView("loginScreen", "account", new Account());
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView mv) {
        mv.setViewName("registerScreen");
        mv.addObject("newAccountDTO", new NewAccountDTO());
        return mv;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("account");
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/register")
    public ModelAndView createAccount(@Valid @ModelAttribute("newAccountDTO") NewAccountDTO newAccountDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("registerScreen", result.getModel());
        }
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/")
    public ModelAndView createSession(HttpSession session, @ModelAttribute Account account) {
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
