package com.upaio.services.command.minio.impl;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.upaio.services.command.minio.GetBucketListMinIOCommand;
import com.upaio.services.model.common.BucketCommonDTO;
import com.upaio.services.model.minio.ServiceResponseGetBucketListMinIODTO;
import io.minio.MinioClient;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import io.minio.messages.Bucket;
import lombok.extern.slf4j.Slf4j;

@Service("GetBucketListMinIOCommand")
@Slf4j
public class GetBucketListMinIOImpl implements GetBucketListMinIOCommand {

  @Override
  public ResponseEntity<ServiceResponseGetBucketListMinIODTO> getBucketList()
      throws ServerException, InsufficientDataException, ErrorResponseException, IOException,
      NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException,
      InternalException {

    log.info("Ejecutando comando: GetBucketListMinIOCommand y su metodo: getBucketList");
    
    ResponseEntity<ServiceResponseGetBucketListMinIODTO> responseEntity = null;
    ServiceResponseGetBucketListMinIODTO responseInternal =
        new ServiceResponseGetBucketListMinIODTO();
    BucketCommonDTO bucketCommonDTO = null;
    List<BucketCommonDTO> bucketList = new ArrayList<>();

    try {
      MinioClient minioClient = generateMiniOConfig();

      for (Bucket bucket : minioClient.listBuckets()) {
        bucketCommonDTO = new BucketCommonDTO();

        bucketCommonDTO.setName(bucket.name());
        bucketCommonDTO.setCreationDate(bucket.creationDate());

        bucketList.add(bucketCommonDTO);
      }

      responseInternal.setBucketList(bucketList);
      responseEntity = ResponseEntity.status(HttpStatus.OK).body(responseInternal);

    } catch (Exception exception) {
      log.error("Error: " + exception);

    }
    return responseEntity;
  }

  private MinioClient generateMiniOConfig() {

    return MinioClient.builder().endpoint("https://play.min.io")
        .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG").build();
  }
}
