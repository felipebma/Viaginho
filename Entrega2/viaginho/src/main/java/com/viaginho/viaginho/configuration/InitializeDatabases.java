package com.viaginho.viaginho.configuration;

import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.model.HotelReservation;
import com.viaginho.viaginho.repositories.AccountRepository;
import com.viaginho.viaginho.repositories.HotelReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializeDatabases implements CommandLineRunner{
    
	@Autowired AccountRepository accountRepository;
	@Autowired HotelReservationRepository hotelReservationRepository;
    
	@Override
	public void run(String... args) throws Exception {
		accountRepository.save(new Account("ze@ze", "ze", "zeze"));
		hotelReservationRepository.save(new HotelReservation(1L, "copacabana palace", "ze@ze", 50000.0));
		hotelReservationRepository.save(new HotelReservation(2L, "intercity", "ze@ze", 2000.0));
	}
    
}
