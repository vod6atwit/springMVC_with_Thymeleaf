package com.learning.springBoot.thymeleafDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learning.springBoot.thymeleafDemo.model.Student;

@Controller
public class StudentControler {

  @Value("${countries}")
  private List<String> countries;

  @Value("${favoriteLanguage}")
  private List<String> favoriteLanguages;

  @Value("${systems}")
  private List<String> systems;

  @GetMapping("/showStudentForm")
  public String showForm(Model theModel) {

    // Create a new Student object
    Student theStudent = new Student();

    // add student object to the model
    theModel.addAttribute("student", theStudent);
    theModel.addAttribute("countries", countries);
    theModel.addAttribute("favoriteLanguages", favoriteLanguages);
    theModel.addAttribute("systems", systems);

    return "student-form";
  }

  @PostMapping("/processStudentForm")
  public String processStudentForm(@ModelAttribute("student") Student theStudent) {

    // log the input data
    System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
    System.out.println("favoriteSystems " + theStudent.getFavoriteSystems());
    return "student-confirmation";

  }
}
