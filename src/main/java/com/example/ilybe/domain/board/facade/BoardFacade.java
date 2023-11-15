package com.example.ilybe.domain.board.facade;

import com.example.ilybe.domain.board.domain.Board;
import com.example.ilybe.domain.board.domain.repository.BoardRepository;
import com.example.ilybe.domain.board.exception.BoardNotFoundException;
import com.example.ilybe.domain.board.exception.MemberMismatchedException;
import com.example.ilybe.domain.board.exception.WriterMismatchedException;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BoardFacade {
    private final BoardRepository boardRepository;
    private final UserFacade userFacade;

    public void checkWriter(Board board) {
        if(!userFacade.getCurrentUser().equals(board.getUser()))
            throw WriterMismatchedException.EXCEPTION;
    }

    public Board findByBoardId(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);
    }

    public List<Board> findByMeet(Meet meet) {
        return boardRepository.findByMeet(meet)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);
    }

    public void checkMember(Meet meet) {
        if(!meet.getUsers().contains(userFacade.getCurrentUser())){
            throw MemberMismatchedException.EXCEPTION;
        }
    }
}
