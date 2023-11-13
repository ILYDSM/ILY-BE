package com.example.ilybe.domain.board.presentation;

import com.example.ilybe.domain.board.presentation.dto.request.BoardRequest;
import com.example.ilybe.domain.board.presentation.dto.response.BoardDetailsResponse;
import com.example.ilybe.domain.board.service.BoardCreateService;
import com.example.ilybe.domain.board.service.BoardDeleteService;
import com.example.ilybe.domain.board.service.BoardDetailsService;
import com.example.ilybe.domain.board.service.BoardUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardCreateService boardCreateService;
    private final BoardUpdateService boardUpdateService;
    private final BoardDeleteService boardDeleteService;
    private final BoardDetailsService boardDetailsService;

    @PostMapping("/{id}")
    public Long BoardCreate(@PathVariable("id") Long meetId, @RequestBody @Valid BoardRequest request) {
        return boardCreateService.execute(meetId, request);
    }

    @PatchMapping("/{id}")
    public void BoardUpdate(@PathVariable("id") Long boardId,  @RequestBody @Valid BoardRequest request) {
        boardUpdateService.execute(boardId, request);
    }

    @DeleteMapping("/{id}")
    public void BoardDelete(@PathVariable("id") Long boardId){
        boardDeleteService.execute(boardId);
    }

    @GetMapping("/{id}")
    public List<BoardDetailsResponse> BoardDetails(@PathVariable("id") Long meetId) {
        return boardDetailsService.execute(meetId);
    }
}
