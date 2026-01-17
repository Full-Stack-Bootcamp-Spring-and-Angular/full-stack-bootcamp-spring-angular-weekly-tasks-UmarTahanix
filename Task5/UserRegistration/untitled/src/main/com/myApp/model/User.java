package main.com.myApp.model;

import lombok.Getter;

@Getter
public class User {
    private String firstName, lastName, email, dateOfBirth, city;

    public User(String firstName, String lastName, String email, String dateOfBirth, String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
    }
}
