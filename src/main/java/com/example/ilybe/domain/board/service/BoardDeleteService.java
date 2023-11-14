package com.example.ilybe.domain.board.service;

import com.example.ilybe.domain.board.domain.Board;
import com.example.ilybe.domain.board.domain.repository.BoardRepository;
import com.example.ilybe.domain.board.facade.BoardFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardDeleteService {
    private final BoardRepository boardRepository;
    private final BoardFacade boardFacade;

    @Transactional
    public void execute(Long boardId) {
        Board board = boardFacade.findByBoardId(boardId);
        boardFacade.checkWriter(board);

        boardRepository.delete(board);
    }
}
