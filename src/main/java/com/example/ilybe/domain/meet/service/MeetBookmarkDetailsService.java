package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.presentation.dto.response.MeetListResponse;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MeetBookmarkDetailsService {
    private final UserFacade userFacade;

    @Transactional
    public List<MeetListResponse> execute() {
        User user = userFacade.getCurrentUser();

        return user.getMeets().stream()
                .map(meet -> MeetListResponse.builder()
                        .meetId(meet.getId())
                        .title(meet.getTitle())
                        .content(meet.getContent())
                        .participant((long) meet.getUsers().size())
                        .build())
                .collect(Collectors.toList());
    }
}
