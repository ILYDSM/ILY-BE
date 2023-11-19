package com.example.ilybe.domain.target.service;

import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.target.domain.repository.TargetRepository;
import com.example.ilybe.domain.target.presentation.dto.response.QueryTargetInfoResponse;
import com.example.ilybe.domain.target.presentation.dto.response.SubTargetResponse;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryTargetInfoService {
    private final TargetRepository targetRepository;
    private final UserFacade userFacade;

    public QueryTargetInfoResponse execute(Long id) {
        User user = userFacade.getCurrentUser();
        Target target = targetRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        List<SubTargetResponse> subTargetResponses = target.getSubTargets()
                .stream()
                .map(it -> new SubTargetResponse(it.getId(), it.getContent(), it.isAchieved()))
                .toList();

        return new QueryTargetInfoResponse(target.getId(), target.getContent(), target.getCycleCount(),
                target.getCycleTerm(), target.getCycleDate(), target.isAchieved(), target.getTheme(), subTargetResponses);
    }
}
