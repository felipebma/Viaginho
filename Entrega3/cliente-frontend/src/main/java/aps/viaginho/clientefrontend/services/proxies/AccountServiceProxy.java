package aps.viaginho.clientefrontend.services.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import aps.viaginho.clientefrontend.model.Account;

@FeignClient(name = "conta-service", url = "localhost:8081")
public interface AccountServiceProxy {

    @PostMapping
    public Account login(@RequestBody Account account);

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account);

}
