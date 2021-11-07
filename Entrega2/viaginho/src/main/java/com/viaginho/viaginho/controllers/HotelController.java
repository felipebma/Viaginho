package com.viaginho.viaginho.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.Facade;
import com.viaginho.viaginho.model.HotelSearchData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelController {
    @Autowired
    Facade facade;

    @GetMapping("/hotel/search")
    public ModelAndView getHotelSearchPage(HttpSession session) {
        ModelAndView mv = new ModelAndView("hotelSearchPage");
        mv.addObject("hotelSearchData", new HotelSearchData());
        return mv;
    }

    @PostMapping("/hotel/search")
    public ModelAndView searchHotel(HttpSession session, @ModelAttribute HotelSearchData hotelSearchData) throws NoSuchAlgorithmException, JsonProcessingException {
        try {
            System.out.println(hotelSearchData);
            facade.getHotels(hotelSearchData);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return new ModelAndView("redirect:/hotel/search");
    }
}
