package com.example.ilybe.domain.user.presentation;

import com.example.ilybe.domain.user.presentation.dto.request.UserSignupRequest;
import com.example.ilybe.domain.user.service.UserSignupService;
import com.example.ilybe.domain.user.service.UserWithdrawlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignupService userSignupService;
    private final UserWithdrawlService userWithdrawlService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signUp(@RequestBody @Validated UserSignupRequest request) {
        userSignupService.execute(request);
    }

    @DeleteMapping
    public void withDrawl() {
        userWithdrawlService.execute();
    }
}