package com.hei.codev.endpoint.rest.controller.health;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EnvControllerTest {
  EnvController subject = new EnvController();

  @Test
  void preprod_env_test() {
    String expected = System.getenv("SECRET_KEY");
    String actual = subject.preprodEnv();
    assertEquals(expected, actual);
  }
}
