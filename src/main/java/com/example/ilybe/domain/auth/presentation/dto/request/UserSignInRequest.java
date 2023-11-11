package com.example.ilybe.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSignInRequest {
    private String email;
    private String password;
}
