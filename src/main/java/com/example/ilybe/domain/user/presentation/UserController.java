package com.example.ilybe.domain.user.presentation;

import com.example.ilybe.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.example.ilybe.domain.user.presentation.dto.request.UpdateUserInfoRequest;
import com.example.ilybe.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.ilybe.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.ilybe.domain.user.service.UpdatePasswordService;
import com.example.ilybe.domain.user.service.UpdateUserInfoService;
import com.example.ilybe.domain.user.service.UserInfoService;
import com.example.ilybe.domain.user.service.UserSignupService;
import com.example.ilybe.domain.user.service.UserWithdrawlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final UserWithdrawlService userWithdrawlService;
    private final UpdatePasswordService updatePasswordService;
    private final UserInfoService userInfoService;
    private final UpdateUserInfoService updateUserInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signUp(@RequestBody @Valid UserSignupRequest request) {
        userSignupService.execute(request);
    }

    @DeleteMapping
    public void withDrawl() {
        userWithdrawlService.execute();
    }

    @PatchMapping("/password")
    public void updatePassword(@RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordService.execute(request);
    }

    @GetMapping("/profile")
    public UserInfoResponse userInfo() {
        return userInfoService.execute();
    }

    @PatchMapping("/profile")
    public void updateUserInfo(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }
}