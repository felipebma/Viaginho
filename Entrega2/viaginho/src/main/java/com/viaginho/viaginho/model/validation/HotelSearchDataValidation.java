package com.viaginho.viaginho.model.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.viaginho.viaginho.model.HotelSearchData;

import org.springframework.stereotype.Component;

@Component
public class HotelSearchDataValidation {

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = HotelSearchDataValidator.class)
    @Documented
    public @interface HotelSearchDataValid {

        String message()

        default "{HotelSearchData.invalid}";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

    }

    public class HotelSearchDataValidator implements ConstraintValidator<HotelSearchDataValid, HotelSearchData> {

        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public boolean isValid(HotelSearchData data, ConstraintValidatorContext context) {
            try {
                Date start = sdf.parse(data.getStartDate());
                Date end = sdf.parse(data.getEndDate());
                return start.after(new Date()) && end.after(start);
            } catch (Exception e) {
                return false;
            }
        }
    }
}
