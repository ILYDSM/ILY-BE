package com.example.ilybe.domain.applicant.service;

import com.example.ilybe.domain.applicant.domain.Applicant;
import com.example.ilybe.domain.applicant.domain.repository.ApplicantRepository;
import com.example.ilybe.domain.applicant.exception.ApplicationNotFoundException;
import com.example.ilybe.domain.applicant.facade.ApplicantFacade;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.repository.MeetRepository;
import com.example.ilybe.domain.meet.facade.MeetFacade;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ApplicantApproveService {
    private final ApplicantRepository applicantRepository;
    private final MeetRepository meetRepository;
    private final UserFacade userFacade;
    private final MeetFacade meetFacade;
    private final ApplicantFacade applicantFacade;

    @Transactional
    public void execute(Long meetId, Long userId, boolean approve) {
        Meet meet = meetFacade.findByMeetId(meetId);
        meetFacade.checkCreator(meet);
        User user = userFacade.findById(userId);
        Applicant applicant = applicantFacade.findByUserAndMeet(userId, meet);

        if(applicant == null) {
            throw ApplicationNotFoundException.EXCEPTION;
        }

        if(approve) {
            applicantRepository.delete(applicant);

            meet.getUsers().add(user);

            meetRepository.save(meet);
        }

        else{
            applicantRepository.delete(applicant);
        }
    }
}
