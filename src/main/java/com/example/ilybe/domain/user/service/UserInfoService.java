package com.example.ilybe.domain.user.service;

import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import com.example.ilybe.domain.user.presentation.dto.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserInfoService {
    private final UserFacade userFacade;

    @Transactional
    public UserInfoResponse execute() {
        User user = userFacade.getCurrentUser();

        return UserInfoResponse.builder()
                .nickname(user.getNickname())
                .email(user.getEmail())
                .point(user.getPoint())
                .build();
    }
}
