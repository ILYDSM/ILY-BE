package com.example.ilybe.domain.board.presentation.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class BoardDetailsResponse {
    private final Long id;
    private final String writerName;
    private final String content;
    private final LocalDateTime createDate;
}
