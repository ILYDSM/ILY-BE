package com.example.ilybe.domain.board.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class WriterMismatchedException extends CustomException {
    public static final CustomException EXCEPTION =
            new WriterMismatchedException();

    private WriterMismatchedException() {
        super(ErrorCode.WRITER_MISMATCHED);
    }
}
