package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.meet.presentation.dto.response.MeetListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MeetSearchService {
    private final MeetFacade meetFacade;

    @Transactional
    public List<MeetListResponse> execute(String keyword) {

        if(keyword == null) {
            return meetFacade.findAll().stream()
                    .map(meet -> MeetListResponse.builder()
                            .meetId(meet.getId())
                            .title(meet.getTitle())
                            .content(meet.getContent())
                            .participant((long) meet.getUsers().size())
                            .build())
                    .collect(Collectors.toList());
        }

        else {
            return meetFacade.findAll().stream()
                    .map(meet -> MeetListResponse.builder()
                            .meetId(meet.getId())
                            .title(meet.getTitle())
                            .content(meet.getContent())
                            .participant((long) meet.getUsers().size())
                            .build())
                    .filter(meet -> meet.getTitle().contains(keyword))
                    .collect(Collectors.toList());
        }
    }

}
