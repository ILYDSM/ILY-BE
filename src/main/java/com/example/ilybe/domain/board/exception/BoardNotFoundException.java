package com.example.ilybe.domain.board.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class BoardNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new BoardNotFoundException();

    private BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
