package aps.viaginho.clientefrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClienteFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteFrontendApplication.class, args);
	}

}
