package main.com.myApp.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordFieldsMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordFieldsMatch {
    String message() default "The password fields must match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
