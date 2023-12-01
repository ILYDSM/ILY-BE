package com.example.ilybe.domain.target.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.repository.MeetRepository;
import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.target.domain.repository.SubTargetRepository;
import com.example.ilybe.domain.target.presentation.dto.response.QueryTargetInfoResponse;
import com.example.ilybe.domain.target.presentation.dto.response.SubTargetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryMeetTargetService {
    private final MeetRepository meetRepository;
    private final SubTargetRepository subTargetRepository;

    @Transactional
    public QueryTargetInfoResponse execute(Long id) {
        Meet meet = meetRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        Target target = meet.getTarget();
        List<SubTargetResponse> subTargetResponses = subTargetRepository.findAllByTarget(target)
                .stream()
                .map(it -> new SubTargetResponse(it.getId(), it.getContent(), it.isAchieved()))
                .toList();

        return new QueryTargetInfoResponse(target.getId(), target.getContent(), target.getCycleCount(),
                target.getCycleTerm(), target.getCycleDate(), target.isAchieved(), target.getTheme(), subTargetResponses);
    }
}
