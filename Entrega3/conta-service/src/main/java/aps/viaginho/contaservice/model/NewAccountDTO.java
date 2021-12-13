package aps.viaginho.contaservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import aps.viaginho.contaservice.model.validation.NewAccountValidation.NewAccountEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAccountDTO {

    @NewAccountEmail(message = "Email already in use")
    @Email(message = "You should inform a valid email")
    @NotBlank(message = "Email must not be blank")
    String email;
    @NotBlank(message = "Name must not be blank")
    String name;
    @NotBlank(message = "password must not be blank")
    String password;

    public Account toAccount() {
        return new Account(email, name, password);
    }
}
