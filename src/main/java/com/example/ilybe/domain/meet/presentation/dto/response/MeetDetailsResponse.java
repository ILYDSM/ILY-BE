package com.example.ilybe.domain.meet.presentation.dto.response;

import com.example.ilybe.domain.meet.domain.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class MeetDetailsResponse {
    private final Long meetId;
    private final Long targetId;
    private final String title;
    private final String content;
    private final List<Type> type;
    private final Long personnel;
    private final Long participant;
}
