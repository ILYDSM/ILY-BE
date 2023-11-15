package com.example.ilybe.domain.board.service;

import com.example.ilybe.domain.board.facade.BoardFacade;
import com.example.ilybe.domain.board.presentation.dto.response.BoardDetailsResponse;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardDetailsService {
    private final MeetFacade meetFacade;
    private final BoardFacade boardFacade;

    @Transactional
    public List<BoardDetailsResponse> execute(Long meetId) {
        Meet meet = meetFacade.findByMeetId(meetId);
        boardFacade.checkMember(meet);

        return boardFacade.findByMeet(meet).stream()
                .map(board -> BoardDetailsResponse.builder()
                        .id(board.getId())
                        .content(board.getContent())
                        .writerName(board.getWriterName())
                        .createDate(board.getCreateDate())
                        .build())
                .collect(Collectors.toList());
    }
}
