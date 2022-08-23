package com.poc.microservicedemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class MicroserviceDemoApplication {

  public static void main(String[] args) {
    log.info("Inciando MicroserviceDemoApplication");

    SpringApplication.run(MicroserviceDemoApplication.class, args);
  }

}
