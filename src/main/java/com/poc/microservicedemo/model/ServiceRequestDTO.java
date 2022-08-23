package com.poc.microservicedemo.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude
public class ServiceRequestDTO implements Serializable {

  private static final long serialVersionUID = -5073446212184200310L;

  private String greeting;


}
