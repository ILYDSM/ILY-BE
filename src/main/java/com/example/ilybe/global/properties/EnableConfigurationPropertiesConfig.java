package com.example.ilybe.global.properties;

import com.example.ilybe.global.security.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {JwtProperties.class})
public class EnableConfigurationPropertiesConfig {
}