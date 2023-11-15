package com.example.ilybe.domain.user.presentation;

import com.example.ilybe.domain.user.presentation.dto.request.UpdatePasswordRequest;
import com.example.ilybe.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.ilybe.domain.user.service.UpdatePasswordService;
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
}