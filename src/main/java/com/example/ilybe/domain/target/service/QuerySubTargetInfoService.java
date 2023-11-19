package com.example.ilybe.domain.target.service;

import com.example.ilybe.domain.target.domain.SubTarget;
import com.example.ilybe.domain.target.domain.repository.SubTargetRepository;
import com.example.ilybe.domain.target.presentation.dto.response.DetailTargetResponse;
import com.example.ilybe.domain.target.presentation.dto.response.QuerySubTargetResponse;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuerySubTargetInfoService {
    private final SubTargetRepository subTargetRepository;

    public QuerySubTargetResponse execute(Long id) {
        SubTarget subTarget = subTargetRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        List<DetailTargetResponse> detailTargetResponses = subTarget.getDetailTargets().stream().map(it ->
                new DetailTargetResponse(it.getId(), it.getContent(), it.isAchieved())
        ).toList();

        return new QuerySubTargetResponse(subTarget.getId(), subTarget.getContent(),
                subTarget.isAchieved(), detailTargetResponses);
    }
}
