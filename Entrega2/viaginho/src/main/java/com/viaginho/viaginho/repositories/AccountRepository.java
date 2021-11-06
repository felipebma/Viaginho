package com.viaginho.viaginho.repositories;

import com.viaginho.viaginho.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    
}
