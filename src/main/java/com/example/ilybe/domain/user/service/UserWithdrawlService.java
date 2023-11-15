package com.example.ilybe.domain.user.service;

import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.domain.repository.UserRepository;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionScoped;

@RequiredArgsConstructor
@Service
public class UserWithdrawlService {
    private final UserFacade userFacade;

    @TransactionScoped
    public void execute() {
        User user = userFacade.getCurrentUser();
        user.setEmail("askfjdsnfdksajfnadskjfnaskjfndsajkn");
    }
}
