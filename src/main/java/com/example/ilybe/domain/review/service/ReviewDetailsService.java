package com.example.ilybe.domain.review.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.review.facade.ReviewFacade;
import com.example.ilybe.domain.review.presentation.dto.response.ReviewDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewDetailsService {
    private final MeetFacade meetFacade;
    private final ReviewFacade reviewFacade;

    public List<ReviewDetailsResponse> execute(Long meetId) {
        Meet meet = meetFacade.findByMeetId(meetId);

        return reviewFacade.findByMeet(meet).stream()
                .map(review -> ReviewDetailsResponse.builder()
                        .id(review.getId())
                        .content(review.getContent())
                        .writerName(review.getWriterName())
                        .createDate(review.getCreateDate())
                        .build())
                .collect(Collectors.toList());
    }
}
