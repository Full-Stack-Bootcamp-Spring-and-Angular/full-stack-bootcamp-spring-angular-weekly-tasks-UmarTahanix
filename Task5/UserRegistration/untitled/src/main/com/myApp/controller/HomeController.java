package main.com.myApp.controller;

import main.com.myApp.dao.DatabaseOperations;
import main.com.myApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static java.lang.Math.abs;

@Controller
public class HomeController
{
    @Autowired
    private DatabaseOperations databaseOperations;

    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName,
                              @RequestParam("email") String email, @RequestParam("date_of_birth") String dateOfBirth,
                              @RequestParam("city") String city, Model model)
    {
        User user = new User(firstName, lastName, email, dateOfBirth, city);
        databaseOperations.storeData(user);

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        model.addAttribute("dateOfBirth", dateOfBirth);
        model.addAttribute("city", city);
        return "resultPage";
    }
}


