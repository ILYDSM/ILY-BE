package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.repository.MeetRepository;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.meet.presentation.dto.request.MeetUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MeetUpdateService {

    private final MeetRepository meetRepository;
    private final MeetFacade meetFacade;

    @Transactional
    public void execute(Long meetId , MeetUpdateRequest request) {
        Meet meet = meetFacade.findByMeetId(meetId);
        meetFacade.checkCreator(meet);

        meet.meetUpdate(request.getTitle(), request.getContent(), request.getType());

        meetRepository.save(meet);
    }
}
