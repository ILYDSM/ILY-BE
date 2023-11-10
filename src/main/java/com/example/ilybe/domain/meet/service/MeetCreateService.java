package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.MeetRepository;
import com.example.ilybe.domain.meet.presentation.dto.request.MeetCreateRequest;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MeetCreateService {
    private final MeetRepository meetRepository;
    private final UserFacade userFacade;

    public Long execute(MeetCreateRequest request) {

        User user = userFacade.getCurrentUser();

        Meet meet = meetRepository.save(Meet.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .type(request.getType())
                .personnel(request.getPersonnel())
                .manager(user)
                .build());

        return meet.getId();
    }
}
