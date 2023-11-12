package com.example.ilybe.domain.applicant.presentation;

import com.example.ilybe.domain.applicant.service.ApplicantCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/applicant")
@RequiredArgsConstructor
@RestController
public class ApplicantController {
    private final ApplicantCreateService applicantCreateService;

    @PostMapping("/{id}")
    public void applicantCreate(@PathVariable("id") Long meetId) {
        applicantCreateService.execute(meetId);
    }

}
