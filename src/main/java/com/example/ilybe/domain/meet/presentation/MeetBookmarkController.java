package com.example.ilybe.domain.meet.presentation;

import com.example.ilybe.domain.meet.service.MeetBookmarkCreateService;
import com.example.ilybe.domain.meet.service.MeetBookmarkDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("bookmark")
@RequiredArgsConstructor
@RestController
public class MeetBookmarkController {
    private final MeetBookmarkCreateService meetBookmarkCreateService;
    private final MeetBookmarkDeleteService meetBookmarkDeleteService;

    @PostMapping("/{id}")
    public void MeetBookmarkCreate(@PathVariable("id") Long meetId) {
        meetBookmarkCreateService.execute(meetId);
    }

    @PatchMapping("/{id}")
    public void MeetBookmarkDelete(@PathVariable("id") Long meetId) {
        meetBookmarkDeleteService.execute(meetId);
    }
}
