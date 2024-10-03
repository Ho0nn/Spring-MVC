package com.luve2code.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // controller method to show initial form
   @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }


//  controller method to read form data and add data to model
    @RequestMapping("/processFormV2")
    public String letsShouDude(HttpServletRequest request, Model model) {

      // read the request parameter from the HTML form
        String name = request.getParameter("studentName");

        // convert data to Uppercase
        name=name.toUpperCase();

        // create a message
        String res= "YO! "+name;

        // add message to the model
        model.addAttribute("message",res);

       return "helloworld";
     }




}
