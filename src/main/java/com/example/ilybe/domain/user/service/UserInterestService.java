package com.example.ilybe.domain.user.service;

import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import com.example.ilybe.domain.user.presentation.dto.response.UserInterestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInterestService {
    private final UserFacade userFacade;
    public UserInterestResponse execute() {
        User user = userFacade.getCurrentUser();

        return UserInterestResponse.builder()
                .interests(user.getInterests())
                .build();
    }
}
