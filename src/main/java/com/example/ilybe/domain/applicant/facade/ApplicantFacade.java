package com.example.ilybe.domain.applicant.facade;

import com.example.ilybe.domain.applicant.domain.Applicant;
import com.example.ilybe.domain.applicant.domain.repository.ApplicantRepository;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<User> listToPage(List<User> applicants, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), applicants.size());
        return new PageImpl<>(applicants.subList(start, end), pageable, applicants.size());
    }
}
