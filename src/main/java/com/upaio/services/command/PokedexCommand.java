package com.upaio.services.command;

import com.upaio.services.model.ServiceResponsePokedexDTO;
import org.springframework.http.ResponseEntity;

public interface PokedexCommand {

  ResponseEntity<ServiceResponsePokedexDTO> getAll();

}
