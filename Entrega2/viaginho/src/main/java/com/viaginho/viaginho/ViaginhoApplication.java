package com.viaginho.viaginho;

import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.model.HotelReservation;
import com.viaginho.viaginho.repositories.AccountRepository;
import com.viaginho.viaginho.repositories.HotelReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ViaginhoApplication implements CommandLineRunner{
	@Autowired AccountRepository accountRepository;
	@Autowired HotelReservationRepository hotelReservationRepository;

	public static void main(String[] args) {
		SpringApplication.run(ViaginhoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		accountRepository.save(new Account("ze@ze", "ze", "zeze"));
		hotelReservationRepository.save(new HotelReservation(1L, "copacabana palace", "ze@ze", 50000.0));
		hotelReservationRepository.save(new HotelReservation(2L, "intercity", "ze@ze", 2000.0));
	}
}
