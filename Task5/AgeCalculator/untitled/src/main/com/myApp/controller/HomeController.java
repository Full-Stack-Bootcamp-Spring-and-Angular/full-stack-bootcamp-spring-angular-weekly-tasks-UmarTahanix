package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static java.lang.Math.abs;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request, Model model)
    {
        int userYears = Integer.parseInt(request.getParameter("year"));
        int userMonths = Integer.parseInt(request.getParameter("month"));
        int userDays = Integer.parseInt(request.getParameter("day"));

        Date date = new Date();
        int currentYear = date.getYear() + 1900;
        int currentMonth = date.getMonth() + 1;
        int currentDay = date.getDay() + 11;

        int yearDiff = currentYear - userYears;
        int monthDiff = abs(currentMonth - userMonths);
        int dayDiff = abs(currentDay - userDays);

        model.addAttribute("yrs", Integer.toString(yearDiff));
        model.addAttribute("mons", Integer.toString(monthDiff));
        model.addAttribute("days", Integer.toString(dayDiff));
        return "resultPage";
    }
}


