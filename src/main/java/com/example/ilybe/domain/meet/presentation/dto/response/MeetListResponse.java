package com.example.ilybe.domain.meet.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class MeetListResponse {
    private final Long meetId;
    private final String title;
    private final String content;
    private final Long participant;
    private final String theme;
}
