package com.example.ilybe.domain.target.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;


@Getter
@AllArgsConstructor
public class QueryTargetInfoResponse {
    private final Long id;
    private final String content;
    private Integer cycleCount;
    private Integer cycleTerm;
    private LocalDate cycleDate;
    private Boolean isAchieved;
    private String theme;
    private List<SubTargetResponse> subTargetResponseList;
}