package com.example.ilybe.domain.record.service;

import com.example.ilybe.domain.record.presentation.dto.response.QueryRecordResponse;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryRecordsService {
    private final UserFacade userFacade;

    public List<QueryRecordResponse> execute() {
        User user = userFacade.getCurrentUser();
        return user.getRecords().stream().map(it -> new QueryRecordResponse(it.getCount(), it.getDate())).toList();
    }
}
