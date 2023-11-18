package com.example.ilybe.domain.target.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryTargetsResponse {
    private final Long id;
    private final String content;
    private final Boolean isAchieved;
}
