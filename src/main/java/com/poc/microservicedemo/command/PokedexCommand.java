package com.poc.microservicedemo.command;

import com.poc.microservicedemo.model.ServiceResponsePokedexDTO;

public interface PokedexCommand {
  
  ServiceResponsePokedexDTO getAll();

}
