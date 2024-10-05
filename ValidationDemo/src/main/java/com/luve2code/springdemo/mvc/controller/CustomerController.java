package com.luve2code.springdemo.mvc.controller;

import com.luve2code.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    // add an initbinider... to convert input strings
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }


    @RequestMapping("/")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }
    @RequestMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult) {
        System.out.println("Last name: |  "+ customer.getLastName() +" |");
        System.out.println("Binding result : " + bindingResult.toString());
        System.out.println("\n\n\n\n");

        if (bindingResult.hasErrors())return "customer-form";
        else return "customer-confirmation";
    }

}
