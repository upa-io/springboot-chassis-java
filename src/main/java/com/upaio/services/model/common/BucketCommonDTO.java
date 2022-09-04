package com.upaio.services.model.common;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude
@Schema(name = "BucketCommonDTO")
public class BucketCommonDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = -922231685582672853L;

  private String name;
  private ZonedDateTime creationDate;
}
