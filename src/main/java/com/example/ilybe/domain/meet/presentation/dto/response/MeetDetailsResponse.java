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
    private String title;
    private String content;
    private List<Type> type;
    private Long personnel;
    private Long participant;
}
