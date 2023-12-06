package com.example.ilybe.domain.meet.presentation;

import com.example.ilybe.domain.meet.presentation.dto.response.MeetBookmarkResponse;
import com.example.ilybe.domain.meet.service.MeetBookmarkCreateService;
import com.example.ilybe.domain.meet.service.MeetBookmarkDeleteService;
import com.example.ilybe.domain.meet.service.MeetBookmarkDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("bookmark")
@RequiredArgsConstructor
@RestController
public class MeetBookmarkController {
    private final MeetBookmarkCreateService meetBookmarkCreateService;
    private final MeetBookmarkDeleteService meetBookmarkDeleteService;
    private final MeetBookmarkDetailsService meetBookmarkDetailsService;

    @PostMapping("/{id}")
    public void meetBookmarkCreate(@PathVariable("id") Long meetId) {
        meetBookmarkCreateService.execute(meetId);
    }

    @PatchMapping("/{id}")
    public void meetBookmarkDelete(@PathVariable("id") Long meetId) {
        meetBookmarkDeleteService.execute(meetId);
    }

    @GetMapping
    public List<MeetBookmarkResponse> setMeetBookmarkDetailsService() {
        return meetBookmarkDetailsService.execute();
    }
}
