package com.learning.springBoot.thymeleafDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class DemoController {

  // create a mapping for "/hello"
  @GetMapping("/hello")
  public String sayHello(Model theModel) {
    theModel.addAttribute("theDate", new java.util.Date());

    // server will look for src/main/resources/templates/helloworld.html
    return "helloworld";
  }

}
