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
<<<<<<< HEAD
public class LoginController {
=======
public class LoginController {// TODO: checar se devemo trocar o nome do login com o createSession
>>>>>>> Fix Create Account use case

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

<<<<<<< HEAD

=======
>>>>>>> Fix Create Account use case
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
        facade.createAccount(newAccountDTO.toAccount());
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/")
<<<<<<< HEAD
    public ModelAndView createSession(HttpSession session, @ModelAttribute Account account) {
=======
    public ModelAndView createSession(HttpSession session, @ModelAttribute Account account) {// TODO: checar
                                                                                             // nomenclatura (esse
                                                                                             // deveria ser o login pois
                                                                                             // recebe o account
                                                                                             // (segundo o diagrama)?)
>>>>>>> Fix Create Account use case
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
