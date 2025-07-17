package com.hei.codev.unit.objectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.hei.codev.conf.FacadeIT;
import com.hei.codev.endpoint.EnvController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class EnvControllerTest extends FacadeIT {
  @Autowired EnvController subject;

  @Value("${SECRET_KEY}")
  private String expected;

  @Test
  void prod_env_test() {
    String actual = subject.preprodEnv();
    log.info("******** Running Env Test ******* ");
    assertEquals(expected, actual);
  }
}
