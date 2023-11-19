package com.example.ilybe.domain.meet.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class MeetListResponse {
    private String title;
    private String content;
    private Long participant;
}
