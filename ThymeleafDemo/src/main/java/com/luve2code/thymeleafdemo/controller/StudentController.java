package com.luve2code.thymeleafdemo.controller;

import com.luve2code.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @GetMapping("/showStudentForm")
    public String showForm(Model model){
       // create student object
        Student student= new Student();
       //  add a student object to model
        model.addAttribute(student);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student){
        System.out.println("student: "+student.getFirstName()+" "+student.getLastName());
        return "student-confirmation";
    }
}
