package main.com.myApp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
@Getter
@Setter
@PasswordFieldsMatch
public class Employee {
    @NotNull(message = "this field cannot be empty or null")
    @Size(min = 1, message = "this field cannot be empty or null")
    private String username;

    @Pattern(regexp = "^\\w+([.-]?\\w+)*@([.-]?\\w+)*(\\.\\w{2,3})+$", message = "please enter a valid address")
    private String email;

    private String password;

    private String confirmPassword;
}
