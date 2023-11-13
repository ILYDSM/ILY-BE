package com.example.ilybe.domain.applicant.service;

import com.example.ilybe.domain.applicant.domain.Applicant;
import com.example.ilybe.domain.applicant.facade.ApplicantFacade;
import com.example.ilybe.domain.applicant.presentation.dto.response.ApplicantListResponse;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ApplicantListService {
    private final ApplicantFacade applicantFacade;
    private final UserFacade userFacade;
    private final MeetFacade meetFacade;

    public Page<ApplicantListResponse> execute(Long meetId, Pageable pageable) {
        Meet meet = meetFacade.findByMeetId(meetId);
        List<Applicant> applicants = applicantFacade.findByMeet(meet);

        List<User> applicationUsers = applicants.stream()
                .map(Applicant::getUser)
                .map(userFacade::findById)
                .map(user -> new User(user.getId(), user.getNickname()))
                .collect(Collectors.toList());

        return applicantFacade.listToPage(applicationUsers, pageable)
                .map(ApplicantListResponse::from);
    }
}
