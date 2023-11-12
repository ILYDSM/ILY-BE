package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.repository.MeetRepository;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MeetDeleteService {
    private final MeetRepository meetRepository;
    private final MeetFacade meetFacade;

    @Transactional
    public void execute(Long meetId) {
        Meet meet = meetFacade.findByMeetId(meetId);
        meetFacade.checkCreator(meet);

        meetRepository.delete(meet);
    }
}
