package com.upaio.services.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.upaio.services.model.common.ServiceResponseResultPokedexDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude
@Schema(name = "ServiceResponsePokedexDTO")
public class ServiceResponsePokedexDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = -7682845143177306759L;

  private String count;
  private String next;
  private String previous;
  private List<ServiceResponseResultPokedexDTO> results;

}
