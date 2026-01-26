package main.com.myApp.model;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordFieldsMatchValidator implements ConstraintValidator<PasswordFieldsMatch, Employee> {

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext cxt){
        return employee.getPassword() != null
                && employee.getPassword().equals(employee.getConfirmPassword());
    }
}
