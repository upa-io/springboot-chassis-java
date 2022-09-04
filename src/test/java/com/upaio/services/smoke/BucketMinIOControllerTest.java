package com.upaio.services.smoke;

import com.upaio.services.controller.BucketMinIOController;
import com.upaio.services.controller.ExampleController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BucketMinIOControllerTest {

    @Autowired
    private BucketMinIOController bucketMinIOController;

    @DisplayName("BucketMinIOController has not null injection")
    @Test
    void contextLoads() throws Exception {
        assertThat(bucketMinIOController).isNotNull();
    }
}
