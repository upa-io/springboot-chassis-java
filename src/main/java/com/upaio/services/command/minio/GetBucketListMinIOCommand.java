package com.upaio.services.command.minio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import com.upaio.services.model.minio.ServiceResponseGetBucketListMinIODTO;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;

public interface GetBucketListMinIOCommand {

  ServiceResponseGetBucketListMinIODTO getBucketList() throws ServerException,
      InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException,
      InvalidKeyException, InvalidResponseException, XmlParserException, InternalException;
}
