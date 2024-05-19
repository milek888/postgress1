package com.example.postgress1.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource")
public record DataBaseProperties(String url, String user, String password) {
}
