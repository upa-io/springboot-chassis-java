package com.poc.microservicedemo.model.common;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude
@Schema(name = "ServiceResponseResultPokedexDTO")
public class ServiceResponseResultPokedexDTO implements Serializable{

  private static final long serialVersionUID = -6117722423974506433L;
  
  String name;
  String url;

}
