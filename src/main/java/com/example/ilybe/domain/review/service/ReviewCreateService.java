package com.example.ilybe.domain.review.service;

import com.example.ilybe.domain.board.facade.BoardFacade;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.review.domain.Review;
import com.example.ilybe.domain.review.domain.repository.ReviewRepository;
import com.example.ilybe.domain.review.presentation.dto.request.ReviewRequest;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReviewCreateService {
    private final MeetFacade meetFacade;
    private final UserFacade userFacade;
    private final BoardFacade boardFacade;
    private final ReviewRepository reviewRepository;

    public void execute(Long meetId, ReviewRequest request) {
        Meet meet = meetFacade.findByMeetId(meetId);
        User user = userFacade.getCurrentUser();
        boardFacade.checkMember(meet);


        reviewRepository.save(Review.builder()
                .writerName(user.getNickname())
                .content(request.getContent())
                .createDate(LocalDateTime.now())
                .user(user)
                .meet(meet)
                .build());
    }
}
