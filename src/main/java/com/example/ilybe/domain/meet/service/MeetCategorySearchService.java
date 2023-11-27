package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Type;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.meet.presentation.dto.response.MeetListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MeetCategorySearchService {
    private final MeetFacade meetFacade;

    @Transactional
    public List<MeetListResponse> execute(Type type, String keyword) {

        return meetFacade.findByType(type).stream()
                .map(meet -> MeetListResponse.builder()
                        .meetId(meet.getId())
                        .title(meet.getTitle())
                        .content(meet.getContent())
                        .participant(meet.getPersonnel())
                        .build())
                .filter(meet -> meet.getTitle().contains(keyword))
                .collect(Collectors.toList());
    }
}
