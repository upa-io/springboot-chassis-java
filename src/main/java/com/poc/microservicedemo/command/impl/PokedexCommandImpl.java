package com.poc.microservicedemo.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.poc.microservicedemo.command.PokedexCommand;
import com.poc.microservicedemo.model.ServiceResponsePokedexDTO;
import lombok.extern.slf4j.Slf4j;

@Service("PokedexCommand")
@Slf4j
public class PokedexCommandImpl implements PokedexCommand {

  private RestTemplate restTemplate;

  @Autowired
  public PokedexCommandImpl(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }

  @Override
  public ServiceResponsePokedexDTO getAll() {
    log.info("Ejecutando metodo getAll de PokedexCommandImpl");

    return restTemplate.getForObject("https://pokeapi.co/api/v2/pokedex",
        ServiceResponsePokedexDTO.class);
  }

}
