package com.upaio.services.model.common;

import java.io.Serial;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude
@Schema(name = "ServiceResponsePokedexDTO")
public class CountryDTO implements Serializable{

  @Serial
  private static final long serialVersionUID = -7682845143177306759L;

  private String id;
  private String name;
    
}
