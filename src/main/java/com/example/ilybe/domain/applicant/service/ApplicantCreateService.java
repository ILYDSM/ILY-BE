package com.example.ilybe.domain.applicant.service;

import com.example.ilybe.domain.applicant.domain.Applicant;
import com.example.ilybe.domain.applicant.domain.repository.ApplicantRepository;
import com.example.ilybe.domain.applicant.exception.ApplicationNotCreateException;
import com.example.ilybe.domain.applicant.facade.ApplicantFacade;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.exception.UserExistException;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ApplicantCreateService {
    private final ApplicantRepository applicantRepository;
    private final UserFacade userFacade;
    private final MeetFacade meetFacade;
    private final ApplicantFacade applicantFacade;

    @Transactional
    public void execute(Long meetId) {
        User user = userFacade.getCurrentUser();
        Meet meet = meetFacade.findByMeetId(meetId);
        Applicant applicant = applicantFacade.findByUserAndMeet(user.getId(), meet);

        if(applicant == null) {
            applicantRepository.save(Applicant.builder()
                    .user(user.getId())
                    .meet(meet)
                    .build());
            return;
        }

        if(meet.getUsers().contains(user)) {
            throw ApplicationNotCreateException.EXCEPTION;
        } else {
            throw UserExistException.EXCEPTION;
        }
    }
}
