package com.poc.microservicedemo.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.poc.microservicedemo.model.common.ServiceResponseResultPokedexDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude
@Schema(name = "ServiceResponsePokedexDTO")
public class ServiceResponsePokedexDTO implements Serializable {
  
  private static final long serialVersionUID = -7682845143177306759L;
  
  String count;
  String next;
  String previous;
  List<ServiceResponseResultPokedexDTO> results;

}
