package com.upaio.services.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.upaio.services.model.ServiceRequestDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1")
@Slf4j
@Tag(name = "ExampleController", description = "Controlador para el manejo de ejemplos")
public class ExampleController {

  Counter visitCounter;

  public ExampleController(MeterRegistry registry) {
    visitCounter = Counter.builder("visit_counter")
            .description("Number of visits to the site")
            .register(registry);
  }

  @PostMapping("/greeting")
  public ResponseEntity<String> postGreeting(@RequestBody ServiceRequestDTO request) {

    log.info("Ejecutando metodo postGreeting");

    visitCounter.increment();

    return new ResponseEntity<>(request.getGreeting(), HttpStatus.OK);

  }

  @PutMapping("greeting")
  public ResponseEntity<String> putGreeting(@RequestBody ServiceRequestDTO request) {

    log.info("Ejecutando metodo putGreeting");

    return new ResponseEntity<>(request.getGreeting(), HttpStatus.OK);

  }

  @DeleteMapping("greeting")
  public ResponseEntity<String> deleteGreeting(@RequestBody ServiceRequestDTO request) {

    log.info("Ejecutando metodo deleteGreeting");

    return new ResponseEntity<>(request.getGreeting(), HttpStatus.OK);

  }

}
