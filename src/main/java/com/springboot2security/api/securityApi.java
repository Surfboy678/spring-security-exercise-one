package com.springboot2security.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class securityApi {

  @GetMapping("/forAdmin")
  public String getAdmin(Principal principal) {
    return "Cześć admin: " + principal.getName();
  }

  @GetMapping("/forUser")
  public String getUser(Principal principal) {
    return "Cześć user: " + principal.getName();
  }

  @GetMapping("/forUnknown")
  public String getNobody(Principal principal) {
    try {
      return "cześć:" + principal.getName();
    } catch (NullPointerException npx) {
      return "cześć nieznajomy";
    }
  }

  @GetMapping("/out")
  public String getInfoByLogout() {
    return "pa pa";
  }
}
