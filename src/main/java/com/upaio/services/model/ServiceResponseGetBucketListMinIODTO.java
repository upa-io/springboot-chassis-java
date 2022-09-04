package com.upaio.services.model;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.upaio.services.model.common.BucketCommonDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude
@Schema(name = "ServiceResponsePutMinIODTO")
public class ServiceResponseGetBucketListMinIODTO implements Serializable {

  @Serial
  private static final long serialVersionUID = -4250850719003867627L;

  private String responseCode;
  private List<BucketCommonDTO> bucketList;
}
