package org.camilogo1200.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

  @RequestMapping(method = RequestMethod.GET, path = "/welcome") //@GetMapping
  public String hellowBanklet() {
    return "Welcome to the Banklet Spring Boot Application, with security.";
  }

}
