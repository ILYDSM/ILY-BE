package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.meet.presentation.dto.response.MeetDetailsResponse;
import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.target.domain.repository.SubTargetRepository;
import com.example.ilybe.domain.target.presentation.dto.response.SubTargetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MeetDetailsService {
    private final MeetFacade meetFacade;
    private final SubTargetRepository subTargetRepository;

    @Transactional
    public MeetDetailsResponse execute(Long meetId) {
        Meet meet = meetFacade.findByMeetId(meetId);

        Target target = meet.getTarget();
        List<SubTargetResponse> subTargetResponses = subTargetRepository.findAllByTarget(target)
                .stream()
                .map(it -> new SubTargetResponse(it.getId(), it.getContent(), it.isAchieved()))
                .collect(Collectors.toList());

        return MeetDetailsResponse.builder()
                .meetId(meet.getId())
                .title(meet.getTitle())
                .meetContent(meet.getContent())
                .type(meet.getType())
                .personnel(meet.getPersonnel())
                .participant((long) meet.getUsers().size())
                .targetId(target.getId())
                .targetContent(target.getContent())
                .cycleCount(target.getCycleCount())
                .cycleTerm(target.getCycleTerm())
                .cycleDate(target.getCycleDate())
                .isAchieved(target.isAchieved())
                .theme(target.getTheme())
                .subTargetResponseList(subTargetResponses)
                .build();
    }
}
