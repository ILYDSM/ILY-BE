package com.example.ilybe.domain.meet.facade;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.repository.MeetRepository;
import com.example.ilybe.domain.user.exception.UserNotFoundException;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MeetFacade {
    private final MeetRepository meetRepository;
    private final UserFacade userFacade;

    public Meet findByMeetId(Long meetId){
        return meetRepository.findById(meetId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public void checkCreator(Meet meet) {
        if(!userFacade.getCurrentUser().equals(meet.getManager()))
            throw UserNotFoundException.EXCEPTION;
    }
}
