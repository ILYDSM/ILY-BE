package com.example.ilybe.domain.auth.service;

import com.example.ilybe.domain.auth.domain.RefreshToken;
import com.example.ilybe.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.ilybe.domain.auth.presentation.dto.response.TokenResponse;
import com.example.ilybe.global.exception.InvalidRefreshTokenException;
import com.example.ilybe.global.exception.RefreshTokenNotFoundException;
import com.example.ilybe.global.security.jwt.JwtProperties;
import com.example.ilybe.global.security.jwt.JwtTokenProvider;
import com.example.ilybe.global.security.jwt.JwtTokenResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TokenRefreshService {
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtTokenResolver jwtTokenResolver;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;


    @Transactional
    public TokenResponse execute(String refreshToken) {
        return reIssue(refreshToken);
    }

    private TokenResponse reIssue(String refreshToken) {
        String parseToken = jwtTokenResolver.parseToken(refreshToken);
        if (parseToken == null) {
            throw InvalidRefreshTokenException.EXCEPTION;
        }

        RefreshToken redisRefreshToken = refreshTokenRepository.findByToken(parseToken)
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

        String email = redisRefreshToken.getEmail();

        String accessToken = jwtTokenProvider.generateAccessToken(email);
        String newRefreshToken = jwtTokenProvider.generateRefreshToken(email);

        redisRefreshToken.updateToken(newRefreshToken, jwtProperties.getRefreshExp());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(newRefreshToken)
                .build();
    }
}