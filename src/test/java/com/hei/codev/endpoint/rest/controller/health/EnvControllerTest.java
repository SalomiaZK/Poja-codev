package com.hei.codev.endpoint.rest.controller.health;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class EnvControllerTest {
  EnvController subject = new EnvController();

  @Test
  void preprod_env_test() {
    String expected = System.getenv("SECRET_KEY");
    String actual = subject.preprodEnv();
    log.info("******** Running Env Test ******* ");
    assertEquals(expected, actual);
  }
}
