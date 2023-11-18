package com.example.ilybe.domain.record.presentation;

import com.example.ilybe.domain.record.presentation.dto.response.QueryRecordResponse;
import com.example.ilybe.domain.record.presentation.dto.response.QueryWeekRecordResponse;
import com.example.ilybe.domain.record.service.QueryRecordsService;
import com.example.ilybe.domain.record.service.QueryWeekRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/graph")
public class RecordController {
    private final QueryRecordsService queryRecordsService;
    private final QueryWeekRecordService queryWeekRecordService;

    @GetMapping("/week")
    public QueryWeekRecordResponse queryWeekRecord() {
        return queryWeekRecordService.execute();
    }

    @GetMapping
    public List<QueryRecordResponse> queryRecord() {
        return queryRecordsService.execute();
    }
}
