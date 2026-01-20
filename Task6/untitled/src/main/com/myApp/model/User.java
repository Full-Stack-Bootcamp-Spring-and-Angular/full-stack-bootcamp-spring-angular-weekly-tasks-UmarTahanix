package main.com.myApp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class User {
    private String username, password, country, programmingLanguage;
    private List<String> operatingSystems;
}
