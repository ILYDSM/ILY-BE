package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.Type;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.meet.presentation.dto.response.MeetListResponse;
import com.example.ilybe.domain.user.domain.Interest;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    @Transactional
    public Page<MeetListResponse> execute(Pageable pageable) {
        User user = userFacade.getCurrentUser();

        List<Type> meetInterests = meetFacade.findAllType();
        List<Interest> userInterests = user.getInterests();

        List<Type> filteredInterests = meetInterests.stream()
                .filter(type -> userInterests.contains(Interest.valueOf(type.name())))
                .collect(Collectors.toList());

        List<Meet> meets = meetFacade.findByTypeIn(filteredInterests).stream().distinct().collect(Collectors.toList());

        Collections.shuffle(meets);

        return listToPage(meets, pageable)
                .map(MeetListResponse::from);

    }

    public Page<Meet> listToPage(List<Meet> meets, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), meets.size());
        return new PageImpl<>(meets.subList(start, end), pageable, meets.size());
    }
}
