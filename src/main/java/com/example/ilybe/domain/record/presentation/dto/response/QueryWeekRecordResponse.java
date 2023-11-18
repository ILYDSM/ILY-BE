package com.example.ilybe.domain.record.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.DayOfWeek;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class QueryWeekRecordResponse {
    private final List<DayOfWeek> days;
}