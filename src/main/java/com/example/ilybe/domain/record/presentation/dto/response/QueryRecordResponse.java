package com.example.ilybe.domain.record.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class QueryRecordResponse {
    private final int count;
    private final LocalDate date;
}
