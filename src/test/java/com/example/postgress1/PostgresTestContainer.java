package com.example.postgress1;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresTestContainer {

    private static final String POSTGRES_DOCKER_IMAGE = "postgres:14-alpine";

    private static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>(POSTGRES_DOCKER_IMAGE);

    static {
        postgresContainer.start();
    }


    @DynamicPropertySource
    void registerProperties(DynamicPropertyRegistry propertyRegistry) {
        propertyRegistry.add("spring.datasource.user", () -> postgresContainer.getUsername());
        propertyRegistry.add("spring.datasource.password", () -> postgresContainer.getPassword());
        propertyRegistry.add("spring.datasource.url", () -> postgresContainer.getJdbcUrl());
    }

}
