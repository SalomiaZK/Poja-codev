package com.hei.codev.unit.objectMapper;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.hei.codev.conf.FacadeIT;
import com.hei.codev.endpoint.EnvController;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ObjectMapperTest extends FacadeIT {
  @Autowired ObjectMapper injectedBean;
  ObjectMapper newInstance = new ObjectMapper();

  SomeClassWithDatetimeField someClassWithDatetimeField =
      new SomeClassWithDatetimeField(Instant.now());

  @Test
  void new_instance_throws_on_java_datetime_module() {
    String jsonString = someClassWithDatetimeField.toJsonString();
    assertThrows(
        InvalidDefinitionException.class,
        () -> newInstance.readValue(jsonString, SomeClassWithDatetimeField.class));
  }

  @Test
  void injected_bean_handles_java_datetime_module() {
    assertDoesNotThrow(
        () ->
            injectedBean.readValue(
                someClassWithDatetimeField.toJsonString(), SomeClassWithDatetimeField.class));
  }

  EnvController subject = new EnvController();

  @Test
  void preprod_env_test() {
    String expected = System.getenv("SECRET_KEY");
    String actual = subject.preprodEnv();
    log.info("******** Running Env Test ******* ");
    Assertions.assertEquals(expected, actual);
  }
}
