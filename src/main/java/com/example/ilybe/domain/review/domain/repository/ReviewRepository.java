package com.example.ilybe.domain.review.domain.repository;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<List<Review>> findByMeet(Meet meet);
}
