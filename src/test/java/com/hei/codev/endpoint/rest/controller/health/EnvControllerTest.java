package com.hei.codev.endpoint.rest.controller.health;

import static org.junit.jupiter.api.Assertions.*;

import com.hei.codev.conf.FacadeIT;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
class EnvControllerTest extends FacadeIT {
  @Autowired EnvController subject;

  @Value("${SECRET_KEY}")
  private String expected;

  @Test
  void preprod_env_test() {
    String actual = subject.preprodEnv();
    log.info("******** Running Env Test ******* ");
    assertEquals(expected, actual);
  }
}
