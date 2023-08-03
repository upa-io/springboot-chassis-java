package com.upaio.services.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upaio.services.model.ServiceRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
class ExampleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @DisplayName("Test call POST")
  @Test
  void postHttpRequest() throws Exception {

    ServiceRequestDTO request = new ServiceRequestDTO ();
    request.setGreeting("Hello!");

    assertNotNull(mockMvc.perform(MockMvcRequestBuilders.post("/v1/greeting").content(asJsonString(request))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)));
  }

  @DisplayName("Test call PUT")
  @Test
  void putHttpRequest() throws Exception {

    ServiceRequestDTO request = new ServiceRequestDTO ();
    request.setGreeting("Hello!");

    assertNotNull(mockMvc.perform(MockMvcRequestBuilders.put("/v1/greeting").content(asJsonString(request))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)));
  }

  @DisplayName("Test call DELETE")
  @Test
  void deleteHttpRequest() throws Exception {

    ServiceRequestDTO request = new ServiceRequestDTO ();
    request.setGreeting("Hello!");

    assertNotNull(mockMvc.perform(MockMvcRequestBuilders.delete("/v1/greeting").content(asJsonString(request))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)));
  }

  public static String asJsonString(final Object obj) {
    try {
      final ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
