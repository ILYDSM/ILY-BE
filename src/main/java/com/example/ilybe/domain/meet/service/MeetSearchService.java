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

        return meetFacade.findAll().stream()
                .map(meet -> MeetListResponse.builder()
                        .title(meet.getTitle())
                        .content(meet.getContent())
                        .participant(meet.getPersonnel())
                        .build())
                .filter(meet -> meet.getTitle().contains(keyword))
                .collect(Collectors.toList());
    }
}
