package com.viaginho.viaginho;

import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ViaginhoApplication implements CommandLineRunner{
	@Autowired AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(ViaginhoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		accountRepository.save(new Account("ze@ze", "ze", "zeze"));
	}

}
