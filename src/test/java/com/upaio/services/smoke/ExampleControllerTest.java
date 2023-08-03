package com.upaio.services.smoke;

import static org.assertj.core.api.Assertions.assertThat;

import com.upaio.services.controller.ExampleController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExampleControllerTest {

  @Autowired
  private ExampleController exampleController;

  @DisplayName("ExampleController has not null injection")
  @Test
  void contextLoads() {
    assertThat(exampleController).isNotNull();
  }

}
