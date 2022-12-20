package com.upaio.services;


import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class MicroserviceDemoApplication {

  public static void main(String[] args) {
    log.info("Inciando MicroserviceDemoApplication");

    SpringApplication.run(MicroserviceDemoApplication.class, args);
  }

  @Bean
  public TimedAspect timedAspect(MeterRegistry registry) {
    return new TimedAspect(registry);
  }

}
