package com.hei.codev.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvControllerhe {

  @Value("${SECRET_KEY}")
  private String secretKey;

  @GetMapping("/preprod-env")
  public String preprodEnv() {
    return secretKey;
  }
}
