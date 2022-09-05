package com.upaio.services.controller.minio;

import com.upaio.services.command.minio.GetBucketListMinIOCommand;
import com.upaio.services.model.minio.ServiceResponseGetBucketListMinIODTO;
import io.minio.errors.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/minio")
@Slf4j
@Tag(name = "BucketMinIOController",
    description = "Controlador que contiene los servicios de los buckets para MiniO")
public class BucketMinIOController {

  @Autowired
  GetBucketListMinIOCommand getBucketListMinIOCommand;

  @GetMapping("/buckets")
  @Operation(summary = "getAllBuckets", description = "Obtener todos los buckets")
  public ServiceResponseGetBucketListMinIODTO getBucketList() throws ServerException,
      InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException,
      InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

    log.info("Ejecutando metodo getBucketList");

    return getBucketListMinIOCommand.getBucketList();
  }


}
