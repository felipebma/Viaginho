package com.viaginho.viaginho.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.Facade;
import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.model.HotelSearchResponse.Hotel;
import com.viaginho.viaginho.model.HotelReservation;

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
        if(!ControllerUtils.hasActiveSession(session)){
            return new ModelAndView("redirect:/");
        }
        ModelAndView mv = new ModelAndView("hotelSearchPage");
        mv.addObject("hotelSearchData", new HotelSearchData());
        return mv;
    }

    @PostMapping("/hotel/search")
    public ModelAndView searchHotel(HttpSession session, @ModelAttribute HotelSearchData hotelSearchData) throws NoSuchAlgorithmException, JsonProcessingException {
        try {
            if(!ControllerUtils.hasActiveSession(session)){
                return new ModelAndView("redirect:/");
            }
            List<Hotel> hotels = facade.getHotels(hotelSearchData);
            ModelAndView mv = new ModelAndView("hotelListScreen");
            mv.addObject("hotels", hotels);
            mv.addObject("searchData", hotelSearchData);
            return mv;
        } catch(Exception e) {
            throw e;
        }
    }

    @GetMapping("hotel/reservations")
    public ModelAndView getReservations(HttpSession session){
        ModelAndView mv = new ModelAndView("hotelReservationScreen");
        if(!ControllerUtils.hasActiveSession(session)){
            return new ModelAndView("redirect:/");
        }
        String userEmail = ((Account)session.getAttribute("account")).getEmail();
        List<HotelReservation> reservations = facade.getReservations(userEmail);
        mv.addObject("reservations", reservations);
        return mv;
    }
}
