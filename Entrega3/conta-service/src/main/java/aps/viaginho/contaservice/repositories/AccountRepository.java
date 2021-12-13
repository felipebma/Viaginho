package aps.viaginho.contaservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import aps.viaginho.contaservice.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

}
