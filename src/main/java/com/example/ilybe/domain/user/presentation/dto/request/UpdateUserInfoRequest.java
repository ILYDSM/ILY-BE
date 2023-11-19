package com.example.ilybe.domain.user.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@NoArgsConstructor
@Getter
public class UpdateUserInfoRequest {
    @Email(message = "email 형식에 맞춰주세요")
    private String email;

    private String nickname;
}
