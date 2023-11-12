package com.example.ilybe.domain.applicant.service;

import com.example.ilybe.domain.applicant.domain.Applicant;
import com.example.ilybe.domain.applicant.domain.repository.ApplicantRepository;
import com.example.ilybe.domain.applicant.exception.ApplicationNotCreateException;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ApplicantCreateService {
    private final ApplicantRepository applicantRepository;
    private final UserFacade userFacade;
    private final MeetFacade meetFacade;

    public void execute(Long meetId) {
        Long user = userFacade.getCurrentUser().getId();
        Meet meet = meetFacade.findByMeetId(meetId);

        if(meet.getUsers().equals(user)) {
            throw ApplicationNotCreateException.EXCEPTION;
        }

        applicantRepository.save(Applicant.builder()
                .user(user)
                .meet(meet)
                .build());
    }
}
