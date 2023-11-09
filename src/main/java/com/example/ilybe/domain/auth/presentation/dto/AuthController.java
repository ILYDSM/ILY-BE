package com.example.ilybe.domain.auth.presentation.dto;

import com.example.ilybe.domain.auth.presentation.dto.response.TokenResponse;
import com.example.ilybe.domain.auth.service.TokenRefreshService;
import com.example.ilybe.domain.auth.service.UserSignInService;

import com.example.ilybe.domain.user.presentation.dto.request.UserSigninRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class AuthController {

    private final UserSignInService userSigninService;
    private final TokenRefreshService tokenRefreshService;

    @PostMapping("/auth")
    public TokenResponse signIn(@RequestBody UserSigninRequest request) {
        return userSigninService.execute(request);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)

    @PatchMapping("/auth")
    public TokenResponse tokenRefresh(@RequestHeader("X-Refresh-Token") String refreshToken) {
        return tokenRefreshService.execute(refreshToken);
    }
}
