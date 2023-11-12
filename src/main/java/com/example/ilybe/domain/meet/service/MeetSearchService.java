package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.meet.presentation.dto.response.MeetListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MeetSearchService {
    private final MeetFacade meetFacade;

    public Page<MeetListResponse> execute(String keyword, Pageable pageable) {
        List<Meet> meets = meetFacade.findAll();

        List<Meet> meetSearch = meets
                .stream()
                .filter(meet -> meet.getTitle().contains(keyword))
                .collect(Collectors.toList());

        return meetFacade.listToPage(meetSearch, pageable)
                .map(MeetListResponse::from);
    }
}
