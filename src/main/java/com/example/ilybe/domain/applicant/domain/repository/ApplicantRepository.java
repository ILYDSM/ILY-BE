package com.example.ilybe.domain.applicant.domain.repository;

import com.example.ilybe.domain.applicant.domain.Applicant;
import com.example.ilybe.domain.meet.domain.Meet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Applicant findByUserAndMeet(Long user, Meet meet);

    List<Applicant> findByMeet(Meet meet);
}
