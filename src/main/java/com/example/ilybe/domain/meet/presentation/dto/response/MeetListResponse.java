package com.example.ilybe.domain.meet.presentation.dto.response;

import com.example.ilybe.domain.meet.domain.Meet;
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

    public static MeetListResponse from(Meet meet) {
        return MeetListResponse.builder()
                .title(meet.getTitle())
                .content(meet.getContent())
                .participant(new Long(meet.getUsers().size()))
                .build();
    }
}
