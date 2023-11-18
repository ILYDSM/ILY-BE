package com.example.ilybe.domain.record.service;

import com.example.ilybe.domain.record.domain.repository.RecordRepository;
import com.example.ilybe.domain.record.presentation.dto.response.QueryWeekRecordResponse;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;

@RequiredArgsConstructor
@Service
public class QueryWeekRecordService {
    private final RecordRepository recordRepository;
    private final UserFacade userFacade;

    public QueryWeekRecordResponse execute() {
        User user = userFacade.getCurrentUser();

        LocalDate today = LocalDate.of(2023, 11, 3);
        int day = today.get(DAY_OF_WEEK);
        LocalDate start = today.minusDays(day-1);
        LocalDate end = start.plusDays(6);
        LocalDate date = start;
        QueryWeekRecordResponse response = new QueryWeekRecordResponse(new ArrayList<>());
        while(date.isBefore(end) || date.isEqual(end)) {
            if(recordRepository.findByDateAndUser(date, user).isPresent()) {
                response.getDays().add(date.getDayOfWeek());
            }
        }

        return response;
    }
}
