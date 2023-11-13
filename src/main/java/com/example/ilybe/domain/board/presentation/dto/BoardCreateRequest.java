package com.example.ilybe.domain.board.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class BoardCreateRequest {
    @NotNull(message = "내용을 입력해주세요.")
    private String content;
}
