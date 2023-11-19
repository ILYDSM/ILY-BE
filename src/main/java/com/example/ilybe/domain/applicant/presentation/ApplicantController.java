package com.example.ilybe.domain.applicant.presentation;

import com.example.ilybe.domain.applicant.presentation.dto.response.ApplicantListResponse;
import com.example.ilybe.domain.applicant.service.ApplicantApproveService;
import com.example.ilybe.domain.applicant.service.ApplicantCreateService;
import com.example.ilybe.domain.applicant.service.ApplicantListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/applicant")
@RequiredArgsConstructor
@RestController
public class ApplicantController {
    private final ApplicantCreateService applicantCreateService;
    private final ApplicantApproveService applicantApproveService;
    private final ApplicantListService applicantListService;

    @PostMapping("/{id}")
    public void applicantCreate(@PathVariable("id") Long meetId) {
        applicantCreateService.execute(meetId);
    }

    @PatchMapping("/{meetId}/{userId}")
    public void applicantApprove(@PathVariable("meetId") Long meetId, @PathVariable("userId") Long userId, @RequestParam boolean approve) {
        applicantApproveService.execute(meetId, userId, approve);
    }

    @GetMapping("/{id}")
    public List<ApplicantListResponse> applicantList(@PathVariable("id") Long meetId) {
        return applicantListService.execute(meetId);
    }

}
