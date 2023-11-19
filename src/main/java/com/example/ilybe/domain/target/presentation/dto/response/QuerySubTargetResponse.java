package com.example.ilybe.domain.target.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuerySubTargetResponse {
    private final Long id;
    private final String content;
    private final Boolean isAchieved;
    private final List<DetailTargetResponse> detailTargetResponses;
}
