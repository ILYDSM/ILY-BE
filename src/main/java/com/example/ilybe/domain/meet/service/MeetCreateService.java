package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.repository.MeetRepository;
import com.example.ilybe.domain.meet.presentation.dto.request.MeetCreateRequest;
import com.example.ilybe.domain.target.domain.DetailTarget;
import com.example.ilybe.domain.target.domain.SubTarget;
import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.target.domain.repository.DetailTargetRepository;
import com.example.ilybe.domain.target.domain.repository.SubTargetRepository;
import com.example.ilybe.domain.target.domain.repository.TargetRepository;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MeetCreateService {
    private final MeetRepository meetRepository;
    private final UserFacade userFacade;
    private final TargetRepository targetRepository;
    private final SubTargetRepository subTargetRepository;
    private final DetailTargetRepository detailTargetRepository;

    @Transactional
    public Long execute(MeetCreateRequest request) {

        User user = userFacade.getCurrentUser();

        Meet meet = meetRepository.save(Meet.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .type(request.getType())
                .personnel(request.getPersonnel())
                .manager(user)
                .build());

        Target target = targetRepository.save(
                Target.builder()
                        .content("")
                        .cycleDate(null)
                        .cycleTerm(null)
                        .cycleCount(null)
                        .user(user)
                        .theme("Gray")
                        .meet(meet)
                        .build()
        );

        for (int i = 0; i <= 7; i++) {
            SubTarget subTarget = subTargetRepository.save(
                    SubTarget.builder()
                            .target(target)
                            .content("")
                            .build());
            int count = i * 8;
            for (int j = count; j <= count + 7; j++) {
                detailTargetRepository.save(
                        DetailTarget.builder()
                                .content("")
                                .subTarget(subTarget)
                                .build()
                );
            }
        }

        return meet.getId();
    }
}
