package com.example.ilybe.domain.board.service;

import com.example.ilybe.domain.board.domain.Board;
import com.example.ilybe.domain.board.domain.repository.BoardRepository;
import com.example.ilybe.domain.board.presentation.dto.request.BoardRequest;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class BoardCreateService {
    private final BoardRepository boardRepository;
    private final MeetFacade meetFacade;
    private final UserFacade userFacade;

    @Transactional
    public Long execute(Long meetId, BoardRequest request) {
        Meet meet = meetFacade.findByMeetId(meetId);
        User user = userFacade.getCurrentUser();

        Board board = boardRepository.save(Board.builder()
                .content(request.getContent())
                .writerName(user.getNickname())
                .createDate(LocalDateTime.now())
                .meet(meet)
                .user(user)
                .build());

        return board.getId();
    }
}
