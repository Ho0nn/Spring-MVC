package com.luve2code.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // controller method to show initial form
   @GetMapping("/showForm")
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
    @RequestMapping("/processFormV3")
    public String letsShouDudeV3(@RequestParam("studentName") String name ,Model model) {


        // convert data to Uppercase
        name=name.toUpperCase();

        // create a message
        String res= "Hey My Friend from v3 ! "+name;

        // add message to the model
        model.addAttribute("message",res);

        return "helloworld";
    }

}
