package com.example.ilybe.domain.board.presentation;

import com.example.ilybe.domain.board.presentation.dto.BoardRequest;
import com.example.ilybe.domain.board.service.BoardCreateService;
import com.example.ilybe.domain.board.service.BoardUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardCreateService boardCreateService;
    private final BoardUpdateService boardUpdateService;

    @PostMapping("/{id}")
    public Long BoardCreate(@PathVariable("id") Long meetId, @RequestBody @Valid BoardRequest request) {
        return boardCreateService.execute(meetId, request);
    }

    @PatchMapping("/{id}")
    public void BoardUpdate(@PathVariable("id") Long boardId,  @RequestBody @Valid BoardRequest request) {
        boardUpdateService.execute(boardId, request);
    }
}
