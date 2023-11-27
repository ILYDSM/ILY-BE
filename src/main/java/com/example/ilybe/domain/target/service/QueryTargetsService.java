package com.example.ilybe.domain.target.service;

import com.example.ilybe.domain.target.domain.repository.TargetRepository;
import com.example.ilybe.domain.target.presentation.dto.response.QueryTargetsResponse;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryTargetsService {
    private final TargetRepository targetRepository;
    private final UserFacade userFacade;

    public List<QueryTargetsResponse> execute() {
        User user = userFacade.getCurrentUser();
        return targetRepository.findAllByUserAndIsViewable(user, true).stream().map(
                it -> new QueryTargetsResponse(it.getId(), it.getContent(), it.isAchieved(), it.getTheme(),
                        it.getMeet())
        ).toList();
    }
}
