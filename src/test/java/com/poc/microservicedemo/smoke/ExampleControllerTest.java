package com.poc.microservicedemo.smoke;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.poc.microservicedemo.controller.ExampleController;

@SpringBootTest
public class ExampleControllerTest {
  
  @Autowired
  private ExampleController exampleController;
  
  @DisplayName("ExampleController has not null injection")
  @Test
  public void contextLoads() throws Exception {
      assertThat(exampleController).isNotNull();
  }

}
