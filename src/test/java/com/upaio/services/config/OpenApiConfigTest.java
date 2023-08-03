package com.upaio.services.config;

import com.upaio.services.config.initializer.OpenApiConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OpenApiConfigTest {

    @Autowired
    private OpenApiConfig openApiConfig;
    @DisplayName("openApiConfig has not null injection")
    @Test
    void contextLoads() {
        assertThat(openApiConfig).isNotNull();
    }

}