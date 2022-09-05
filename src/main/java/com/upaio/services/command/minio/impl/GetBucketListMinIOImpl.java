package com.upaio.services.command.minio.impl;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
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
  public ServiceResponseGetBucketListMinIODTO getBucketList() throws ServerException,
      InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException,
      InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

    log.info("Ejecutando comando: GetBucketListMinIOCommand y su metodo: getBucketList");

    ServiceResponseGetBucketListMinIODTO response = new ServiceResponseGetBucketListMinIODTO();
    BucketCommonDTO bucketCommonDTO = null;
    List<BucketCommonDTO> bucketList = new ArrayList<>();

    MinioClient minioClient = generateMiniOConfig();

      for (Bucket bucket : minioClient.listBuckets()) {
        bucketCommonDTO = new BucketCommonDTO();

        bucketCommonDTO.setName(bucket.name());
        bucketCommonDTO.setCreationDate(bucket.creationDate());

        bucketList.add(bucketCommonDTO);
      }

    response.setBucketList(bucketList);
    response.setResponseCode("200");
    return response;
  }

  private MinioClient generateMiniOConfig() {

    return MinioClient.builder().endpoint("https://play.min.io")
        .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG").build();
  }
}
