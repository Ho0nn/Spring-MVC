package com.luve2code.thymeleafdemo.controller;
import com.luve2code.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String>languages;
    @RequestMapping("/showStudentForm")
    public String showForm(Model model){
       // create student object
        Student student= new Student();
       //  add a student object to model
        model.addAttribute("student",student);

        // add the countries to the model
        model.addAttribute("countries",countries);
        // add languages to the model
        model.addAttribute("languages",languages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student){
        System.out.println("student: "+student.getFirstName()+" "+student.getLastName());
        return "student-confirmation";
    }
}
