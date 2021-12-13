package aps.viaginho.clientefrontend.model.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.stereotype.Component;

@Component
public class NewAccountValidation {

    @Target({ ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = NewAccountEmailValidator.class)
    @Documented
    public @interface NewAccountEmail {

        String message() default "{NewAccount.invalid}";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

    }

    public class NewAccountEmailValidator implements ConstraintValidator<NewAccountEmail, String> {

        // @Autowired
        // Facade facade;

        @Override
        public boolean isValid(String email, ConstraintValidatorContext context) {
            // return !facade.accountExists(email);
            return true;
        }
    }

}
