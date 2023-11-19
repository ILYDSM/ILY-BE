package com.example.ilybe.domain.user.service;

import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.domain.repository.UserRepository;
import com.example.ilybe.domain.user.facade.UserFacade;
import com.example.ilybe.domain.user.presentation.dto.request.UpdateInterestRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateInterestService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;

    public void execute(UpdateInterestRequest request) {
        User user = userFacade.getCurrentUser();

        user.updateInterest(request.getInterests());

        userRepository.save(user);
    }
}
