package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.domain.repository.UserRepository;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MeetBookmarkDeleteService {
    private final UserRepository userRepository;
    private final MeetFacade meetFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long meetId) {
        Meet meet = meetFacade.findByMeetId(meetId);
        User user = userFacade.getCurrentUser();

        List<Meet> meets = user.getMeets();

        meets.remove(meet);

        userRepository.save(user);
    }
}
