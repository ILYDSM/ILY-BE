package com.example.ilybe.domain.meet.service;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.exception.AlreadyBookmarkedException;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.domain.repository.UserRepository;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MeetBookmarkService {
    private final UserRepository userRepository;
    private final MeetFacade meetFacade;
    private final UserFacade userFacade;

    public void execute(Long meetId) {
        Meet meet = meetFacade.findByMeetId(meetId);
        User user = userFacade.getCurrentUser();

        List<Meet> bookmarks = user.getBookmarks();

        if(!bookmarks.contains(meet)){
            bookmarks.add(meet);
        }
        else{
            throw AlreadyBookmarkedException.EXCEPTION;
        }

        userRepository.save(user);

    }
}
