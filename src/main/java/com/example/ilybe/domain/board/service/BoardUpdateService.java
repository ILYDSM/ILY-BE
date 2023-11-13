package com.example.ilybe.domain.board.service;

import com.example.ilybe.domain.board.domain.Board;
import com.example.ilybe.domain.board.domain.repository.BoardRepository;
import com.example.ilybe.domain.board.facade.BoardFacade;
import com.example.ilybe.domain.board.presentation.dto.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class BoardUpdateService {
    private final BoardRepository boardRepository;
    private final BoardFacade boardFacade;

    public void execute(Long boardId, BoardRequest request) {
        Board board = boardFacade.findByBoardId(boardId);
        boardFacade.CheckWriter(board);

        board.boardUpdate(request.getContent(), LocalDateTime.now());

        boardRepository.save(board);
    }
}
