package com.stydy.study1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/user")
public class UserController {
  @GetMapping("/searchUser")
  public String searchUser(@RequestParam String param) {
      return "searchUser";
  }
  
}
