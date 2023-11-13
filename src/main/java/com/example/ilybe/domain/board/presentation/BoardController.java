package com.example.ilybe.domain.board.presentation;

import com.example.ilybe.domain.board.presentation.dto.BoardCreateRequest;
import com.example.ilybe.domain.board.service.BoardCreateService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/{id}")
    public void BoardCreate(@PathVariable("id") Long meetId, @RequestBody @Valid BoardCreateRequest request) {
        boardCreateService.execute(meetId, request);
    }
}
