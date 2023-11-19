package com.example.ilybe.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class UserInfoResponse {
    private String email;
    private String nickname;
    private Integer point;
}
