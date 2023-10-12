package com.example.ilybe.global.exception;


import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class SignatureJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new SignatureJwtException();

    private SignatureJwtException() {
        super(ErrorCode.SIGNATURE_JWT);
    }
}