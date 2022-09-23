package com.upaio.services.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.upaio.services.command.PokedexCommand;
import com.upaio.services.model.ServiceResponsePokedexDTO;
import lombok.extern.slf4j.Slf4j;

@Service("PokedexCommand")
@Slf4j
public class PokedexCommandImpl implements PokedexCommand {

  private final RestTemplate restTemplate;

  @Autowired
  public PokedexCommandImpl(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }

  @Override
  public ResponseEntity<ServiceResponsePokedexDTO> getAll() {
    log.info("Ejecutando metodo getAll de PokedexCommandImpl");

    ResponseEntity<ServiceResponsePokedexDTO> responseEntity = null;

    try {
      responseEntity = ResponseEntity.status(HttpStatus.OK).body(restTemplate
          .getForObject("https://pokeapi.co/api/v2/pokedex", ServiceResponsePokedexDTO.class));
    } catch (Exception exception) {
      log.error("Error: " + exception);
      responseEntity = ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();

    }
    return responseEntity;
  }

}
