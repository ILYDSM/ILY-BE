package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.repository.MeetRepository;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MeetWithdrawService {
    private final MeetFacade meetFacade;
    private final UserFacade userFacade;
    private final MeetRepository meetRepository;

    @Transactional
    public void execute(Long meetId) {
        Meet meet = meetFacade.findByMeetId(meetId);
        List<User> users = meet.getUsers();

        users.removeIf(user -> user.getId().equals(userFacade.getCurrentUser().getId()));

        meetRepository.save(meet);
    }
}
