package org.camilogo1200.springsecurity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

  @RequestMapping(method = RequestMethod.GET, path = "/") //@GetMapping
  public String hellowBanklet() {
    return "Welcome to the Banklet Spring Boot Application, with security.";
  }

  @GetMapping("/welcome")
  public String welcome(@AuthenticationPrincipal OidcUser user) {
    String name = (user != null ? user.getFullName() : "anonymous");
    return "Welcome, " + name + "!";
  }

}
