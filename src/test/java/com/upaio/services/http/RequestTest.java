package com.upaio.services.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.upaio.services.model.minio.ServiceResponseGetBucketListMinIODTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.AssertionErrors;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RequestTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @DisplayName("GetAll for PokedexCommand")
  @Test
  void getAllPokedexShouldReturnDefaultMessage() throws Exception {
    assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/ms-rest-api/v1/",
        String.class)).contains("count");
  }

  @DisplayName("GetBucketList for MinIO")
  @Test
  void getBucketlistShouldReturnDefaultMessage() throws Exception {

    ResponseEntity<ServiceResponseGetBucketListMinIODTO> responseEntity = this.restTemplate.getForEntity("http://localhost:" + port + "/ms-rest-api/minio/buckets/",
            ServiceResponseGetBucketListMinIODTO.class);
    assertNotNull(responseEntity);
    assertEquals(200, responseEntity.getStatusCode().value());
  }

}
