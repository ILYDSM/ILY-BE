package com.example.ilybe.domain.user.service;

import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.domain.repository.UserRepository;
import com.example.ilybe.domain.user.facade.UserFacade;
import com.example.ilybe.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateUserInfoService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    @Transactional
    public void execute(UpdateUserInfoRequest request) {
        User user = userFacade.getCurrentUser();

        if(request.getEmail() == null)
            user.updateUserInfo(user.getEmail(), request.getNickname());

        else if(request.getNickname() == null)
            user.updateUserInfo(request.getEmail(), user.getNickname());

        if(request.getEmail() != null && !user.getEmail().equals(request.getEmail())) {
            userFacade.checkUserExist(request.getEmail());
            user.updateUserInfo(request.getEmail(), request.getNickname());
        }

        userRepository.save(user);
    }
}
