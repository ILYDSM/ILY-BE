package com.example.ilybe.domain.applicant.service;

import com.example.ilybe.domain.applicant.domain.Applicant;
import com.example.ilybe.domain.applicant.facade.ApplicantFacade;
import com.example.ilybe.domain.applicant.presentation.dto.response.ApplicantListResponse;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApplicantListService {
    private final ApplicantFacade applicantFacade;
    private final UserFacade userFacade;
    private final MeetFacade meetFacade;

    @Transactional
    public List<ApplicantListResponse> execute(Long meetId) {
        Meet meet = meetFacade.findByMeetId(meetId);
        meetFacade.checkCreator(meet);
        List<Applicant> applicants = applicantFacade.findByMeet(meet);
        User user = userFacade.getCurrentUser();

        return applicants.stream()
                .map(applicant -> ApplicantListResponse.builder()
                        .nickname(user.getNickname())
                        .userId(user.getId())
                        .build())
                .collect(Collectors.toList());
    }
}
