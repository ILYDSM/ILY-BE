package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.meet.presentation.dto.response.MeetDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MeetDetailsService {
    private final MeetFacade meetFacade;

    @Transactional
    public MeetDetailsResponse execute(Long meetId) {
        Meet meet = meetFacade.findByMeetId(meetId);
        Long users = (long) meet.getUsers().size();

        return MeetDetailsResponse.builder()
                .title(meet.getTitle())
                .content(meet.getContent())
                .type(meet.getType())
                .personnel(meet.getPersonnel())
                .participant(users)
                .build();
    }
}
