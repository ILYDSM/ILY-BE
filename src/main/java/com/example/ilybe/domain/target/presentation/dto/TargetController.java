package com.example.ilybe.domain.target.presentation.dto;

import com.example.ilybe.domain.target.presentation.dto.request.CreateTargetRequest;
import com.example.ilybe.domain.target.service.CreateTargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/target")
public class TargetController {
    private final CreateTargetService createTargetService;

    @PostMapping
    public void createTarget(@RequestBody @Valid CreateTargetRequest request) {
        createTargetService.execute(request);
    }
}
