package com.example.ilybe.domain.meet.presentation;

import com.example.ilybe.domain.meet.service.MeetBookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("bookmark")
@RequiredArgsConstructor
@RestController
public class MeetBookmarkController {
    private final MeetBookmarkService meetBookmarkService;

    @PatchMapping("/{id}")
    public void MeetBookmark(@PathVariable("id") Long meetId) {
        meetBookmarkService.execute(meetId);
    }
}
