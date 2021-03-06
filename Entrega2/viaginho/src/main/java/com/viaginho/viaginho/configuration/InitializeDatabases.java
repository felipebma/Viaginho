package com.viaginho.viaginho.configuration;

import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.model.HotelReservation;
import com.viaginho.viaginho.repositories.AccountRepository;
import com.viaginho.viaginho.repositories.HotelReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitializeDatabases implements CommandLineRunner {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	HotelReservationRepository hotelReservationRepository;

	@Override
	public void run(String... args) throws Exception {
		accountRepository.save(new Account("ze@ze", "ze", "zeze"));
		hotelReservationRepository.deleteAll();
		hotelReservationRepository.save(
				new HotelReservation("#1", "COP", "Copacabana Palace", "ze@ze", "2021-12-27", "2021-12-31", 500.0));
		hotelReservationRepository.save(
				new HotelReservation("#2", "INT", "Intercity Ibirapuera", "ze@ze", "2022-01-01", "2022-01-10", 75.0));
	}

}
