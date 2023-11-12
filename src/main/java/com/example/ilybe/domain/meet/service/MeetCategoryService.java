package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Type;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.meet.presentation.dto.response.MeetListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MeetCategoryService {
    private final MeetFacade meetFacade;

    public Page<MeetListResponse> execute(Type type, Pageable pageable) {
        return meetFacade.findByType(type, pageable)
                .map(MeetListResponse::from);
    }
}
