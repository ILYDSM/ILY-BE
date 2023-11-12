package com.example.ilybe.domain.target.service;

import com.example.ilybe.domain.target.domain.DetailTarget;
import com.example.ilybe.domain.target.domain.SubTarget;
import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.target.domain.repository.DetailTargetRepository;
import com.example.ilybe.domain.target.domain.repository.SubTargetRepository;
import com.example.ilybe.domain.target.domain.repository.TargetRepository;
import com.example.ilybe.domain.target.presentation.dto.request.CreateTargetRequest;
import com.example.ilybe.domain.theme.domain.Theme;
import com.example.ilybe.domain.theme.domain.repository.ThemeRepository;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateTargetService {
    private final TargetRepository targetRepository;
    private final SubTargetRepository subTargetRepository;
    private final DetailTargetRepository detailTargetRepository;

    private final ThemeRepository themeRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateTargetRequest request) {
        if (request.getSubTargets().size() != 8 || request.getDetailTargets().size() != 64)
            throw new IllegalArgumentException();

        User user = userFacade.getCurrentUser();

        Theme theme = null;

        if(request.getThemeId() != null) {
            theme = themeRepository.findById(request.getThemeId())
                    .orElseThrow();

            user.minusPoint(theme.getPrice());
        }

        Target target = targetRepository.save(
                Target.builder()
                        .content(request.getTarget())
                        .cycleDate(request.getCycleDate())
                        .cycleTerm(request.getCycleTerm())
                        .cycleCount(request.getCycleCount())
                        .theme(theme)
                        .user(user)
                        .build()
        );

        for (int i = 0; i <= 7; i++) {
            SubTarget subTarget = subTargetRepository.save(
                    SubTarget.builder()
                            .target(target)
                            .content(request.getSubTargets().get(i))
                            .build());
            int count = i * 8;
            for (int j = count; j <= count + 7; j++) {
                detailTargetRepository.save(
                        DetailTarget.builder()
                                .content(request.getDetailTargets().get(j))
                                .subTarget(subTarget)
                                .build()
                );
            }
        }
    }
}