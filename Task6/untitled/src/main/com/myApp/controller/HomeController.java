package main.com.myApp.controller;

import main.com.myApp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static java.lang.Math.abs;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String showHomePage(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("user") User user, Model model)
    {
        model.addAttribute("userResult", user);
        return "resultPage";
    }
}


