package com.hei.codev.endpoint.rest.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {
  @GetMapping("/preprod-env")
  public String preprodEnv() {
    return System.getenv("SECRET_KEY");
  }
}
