package com.example.ilybe.global.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "auth.jwt")
public class JwtProperties {

    private final String secret;
    private final Long accessExp;
    private final Long refreshExp;
}