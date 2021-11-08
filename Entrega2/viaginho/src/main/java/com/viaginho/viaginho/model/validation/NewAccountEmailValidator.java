package com.viaginho.viaginho.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.viaginho.viaginho.Facade;

import org.springframework.beans.factory.annotation.Autowired;

public class NewAccountEmailValidator implements ConstraintValidator<NewAccountEmail, String>{

  @Autowired
  Facade facade;

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
    return !facade.accountExists(email);
  }

}
