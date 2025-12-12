package com.employees.webapp.repository;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.employees.webapp")
public class CustomProperties {
  private String apiUrl;
}
