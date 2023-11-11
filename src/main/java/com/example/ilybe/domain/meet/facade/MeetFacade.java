package com.example.ilybe.domain.meet.facade;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.Type;
import com.example.ilybe.domain.meet.domain.repository.MeetRepository;
import com.example.ilybe.domain.meet.exception.CreatorMismatchedException;
import com.example.ilybe.domain.meet.exception.MeetNotFoundException;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MeetFacade {
    private final MeetRepository meetRepository;
    private final UserFacade userFacade;

    public Meet findByMeetId(Long meetId){
        return meetRepository.findById(meetId)
                .orElseThrow(() -> MeetNotFoundException.EXCEPTION);
    }

    public void checkCreator(Meet meet) {
        if(!userFacade.getCurrentUser().equals(meet.getManager()))
            throw CreatorMismatchedException.EXCEPTION;
    }

    public List<Type> findAllType() {
        return meetRepository.findAllType();
    }

    public List<Meet> findByTypeIn(List<Type> type) {
        return meetRepository.findByTypeIn(type)
                .orElseThrow(() -> MeetNotFoundException.EXCEPTION);
    }

    public Page<Meet> findByType(Type type, Pageable pageable) {
        return meetRepository.findByType(type, pageable)
                .orElseThrow(() -> MeetNotFoundException.EXCEPTION);
    }

    public List<Meet> findAll() {
        return meetRepository.findAll();
    }

    public List<Meet> findByType(Type type) {
        return meetRepository.findByType(type)
                .orElseThrow(() -> MeetNotFoundException.EXCEPTION);
    }

    public Page<Meet> listToPage(List<Meet> meets, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), meets.size());
        return new PageImpl<>(meets.subList(start, end), pageable, meets.size());
    }
}
