package main.com.myApp.controller;

import main.com.myApp.dao.DatabaseOperations;
import main.com.myApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController
{
    @Autowired
    private DatabaseOperations databaseOperations;

    @RequestMapping("/")
    public String showHomePage(Model model)
    {
        model.addAttribute("employee", new Employee());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processFormData(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
            return "formPage";
        databaseOperations.storeData(employee);
        model.addAttribute("employeeResult", employee);
        return "resultPage";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}


