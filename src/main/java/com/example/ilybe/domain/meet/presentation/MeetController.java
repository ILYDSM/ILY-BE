package com.example.ilybe.domain.meet.presentation;

import com.example.ilybe.domain.meet.presentation.dto.request.MeetCreateRequest;
import com.example.ilybe.domain.meet.presentation.dto.request.MeetUpdateRequest;
import com.example.ilybe.domain.meet.service.MeetCreateService;
import com.example.ilybe.domain.meet.service.MeetUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final MeetUpdateService meetUpdateService;

    @PostMapping
    public Long MeetCreate(@RequestBody @Valid MeetCreateRequest request) {
        return meetCreateService.execute(request);
    }

    @PatchMapping("/{id}")
    public void MeetUpdate(@PathVariable("id") Long meetId, @RequestBody @Valid MeetUpdateRequest request) {
        meetUpdateService.execute(meetId, request);
    }
}
