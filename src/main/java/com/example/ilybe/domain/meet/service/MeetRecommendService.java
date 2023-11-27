package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Type;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.meet.presentation.dto.response.MeetListResponse;
import com.example.ilybe.domain.target.domain.repository.TargetRepository;
import com.example.ilybe.domain.user.domain.Interest;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MeetRecommendService {
    private final UserFacade userFacade;
    private final MeetFacade meetFacade;
    private final TargetRepository targetRepository;

    @Transactional
    public List<MeetListResponse> execute() {
        User user = userFacade.getCurrentUser();

        List<Type> meetInterests = meetFacade.findAllType();
        List<Interest> userInterests = user.getInterests();

        List<Type> filteredInterests = meetInterests.stream()
                .filter(type -> userInterests.contains(Interest.valueOf(type.name())))
                .collect(Collectors.toList());

        List<MeetListResponse> meets = meetFacade.findByTypeIn(filteredInterests).stream()
                .distinct()
                .map(meet -> MeetListResponse.builder()
                        .meetId(meet.getId())
                        .title(meet.getTitle())
                        .content(meet.getContent())
                        .participant((long) meet.getUsers().size())
                        .build())
                .collect(Collectors.toList());

        Collections.shuffle(meets);

        return meets;

    }
}
