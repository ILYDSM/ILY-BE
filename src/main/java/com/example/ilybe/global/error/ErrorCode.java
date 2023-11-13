package com.example.ilybe.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    APPLICATION_NOT_CREATE(400, "Application Not Create"),
    PASSWORD_MISMATCH(401-1, "Password Mismatch"),

    EXPIRED_JWT(401-2, "Expired Jwt"),
    SIGNATURE_JWT(401-3, "Signature Jwt"),
    INVALID_JWT(401-4, "Invalid Jwt"),

    INVALID_REFRESH_TOKEN(401-5, "Invalid Refresh Token"),

    CREATOR_MISMATCHED(403-1, "Creator Mismatched"),

    USER_NOT_FOUND(404-1, "User Not Found"),
    MEET_NOT_FOUND(404-2, "Meet Not Found"),
    APPLICATION_NOT_FOUND(404-3, "Application Not Found"),

    REFRESH_TOKEN_NOT_FOUND(404-4, "RefreshToken Not Found"),

    USER_EXIST(409-1, "User Exist"),

    ALREADY_BOOKMARKED(409-2, "Already Bookmarked"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int status;
    private final String message;
}