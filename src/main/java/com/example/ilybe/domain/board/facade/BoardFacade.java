package com.example.ilybe.domain.board.facade;

import com.example.ilybe.domain.board.domain.Board;
import com.example.ilybe.domain.board.domain.repository.BoardRepository;
import com.example.ilybe.domain.board.exception.BoardNotFoundException;
import com.example.ilybe.domain.board.exception.WriterMismatchedException;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BoardFacade {
    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public void CheckWriter(Board board) {
        if(!userFacade.getCurrentUser().equals(board.getUser()))
            throw WriterMismatchedException.EXCEPTION;
    }

    public Board findByBoardId(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);
    }
}
