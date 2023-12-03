package com.example.ilybe.domain.meet.presentation.dto.response;

import com.example.ilybe.domain.meet.domain.Type;
import com.example.ilybe.domain.target.presentation.dto.response.SubTargetResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class MeetDetailsResponse {
    private final Long meetId;
    private final String title;
    private final String meetContent;
    private final List<Type> type;
    private final Long personnel;
    private final Long participant;
    private final Long targetId;
    private final String targetContent;
    private Integer cycleCount;
    private Integer cycleTerm;
    private LocalDate cycleDate;
    private Boolean isAchieved;
    private String theme;
    private List<SubTargetResponse> subTargetResponseList;
}
