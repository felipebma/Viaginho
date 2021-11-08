package com.viaginho.viaginho.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.Facade;
import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.model.HotelReservation;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.model.HotelSearchResponse.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SuppressWarnings("unchecked")
public class HotelController {
    @Autowired
    Facade facade;

    @GetMapping("/hotel/search")
    public ModelAndView getHotelSearchPage(HttpSession session) {
        if (!ControllerUtils.hasActiveSession(session)) {
            return new ModelAndView("redirect:/");
        }
        ModelAndView mv = new ModelAndView("hotelSearchPage");
        mv.addObject("hotelSearchData", new HotelSearchData());
        return mv;
    }

    @PostMapping("/hotel/search")
    public ModelAndView searchHotel(HttpSession session, @ModelAttribute HotelSearchData hotelSearchData)
            throws NoSuchAlgorithmException, JsonProcessingException {
        try {
            if (!ControllerUtils.hasActiveSession(session)) {
                return new ModelAndView("redirect:/");
            }
            List<Hotel> hotels = facade.getHotels(hotelSearchData);
            session.setAttribute("hotels", hotels);
            session.setAttribute("startDate", hotelSearchData.getStartDate());
            session.setAttribute("endDate", hotelSearchData.getEndDate());
            ModelAndView mv = new ModelAndView("hotelListScreen");
            mv.addObject("hotels", hotels);
            mv.addObject("searchData", hotelSearchData);
            return mv;
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("hotel/reservations")
    public ModelAndView getReservations(HttpSession session) {
        ModelAndView mv = new ModelAndView("hotelReservationScreen");
        if (!ControllerUtils.hasActiveSession(session)) {
            return new ModelAndView("redirect:/");
        }
        String userEmail = ((Account) session.getAttribute("account")).getEmail();
        List<HotelReservation> reservations = facade.getReservations(userEmail);
        mv.addObject("reservations", reservations);
        return mv;
    }

    @PostMapping("/hotel/reservations/{cheapest}/{hotelId}")
    public ModelAndView makeReservation(HttpSession session, @PathVariable Boolean cheapest,
            @PathVariable Integer hotelId) {
        if (!ControllerUtils.hasActiveSession(session)) {
            return new ModelAndView("redirect:/");
        }
        List<Hotel> hotels = (List<Hotel>) session.getAttribute("hotels");
        String checkInDate = (String) session.getAttribute("startDate");
        String checkOutDate = (String) session.getAttribute("endDate");
        session.removeAttribute("hotels");
        session.removeAttribute("startDate");
        session.removeAttribute("endDate");
        Hotel hotel = hotels.get(hotelId);
        double price = Double.parseDouble(cheapest ? hotel.getMinRate() : hotel.getMaxRate());
        HotelReservation hotelReservation = new HotelReservation(String.valueOf(hotel.getCode()), hotel.getName(),
                ControllerUtils.getUserEmail(session), checkInDate, checkOutDate, price);
        facade.createHotelReservation(hotelReservation);
        ModelAndView mv = new ModelAndView("redirect:/hotel/reservations");
        return mv;
    }
}
