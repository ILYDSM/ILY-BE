package com.example.ilybe.domain.meet.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class MeetBookmarkResponse {
    private final Long meetId;
    private final String title;
    private final String content;
    private final Long participant;
    private final String theme;
}
