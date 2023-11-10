package com.example.ilybe.domain.meet.presentation;

import com.example.ilybe.domain.meet.presentation.dto.request.MeetCreateRequest;
import com.example.ilybe.domain.meet.service.MeetCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/meet")
@RequiredArgsConstructor
@RestController
public class MeetController {
    private final MeetCreateService meetCreateService;

    @PostMapping
    public Long MeetGenerate(@RequestBody @Valid MeetCreateRequest request) {
        return meetCreateService.execute(request);
    }
}
