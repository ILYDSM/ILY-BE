package com.example.ilybe.domain.applicant.facade;

import com.example.ilybe.domain.applicant.domain.Applicant;
import com.example.ilybe.domain.applicant.domain.repository.ApplicantRepository;
import com.example.ilybe.domain.meet.domain.Meet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ApplicantFacade {
    private final ApplicantRepository applicantRepository;

    public Applicant findByUserAndMeet(Long user, Meet meet) {
        return applicantRepository.findByUserAndMeet(user, meet);
    }

    public List<Applicant> findByMeet(Meet meet) {
        return applicantRepository.findByMeet(meet);
    }
}
