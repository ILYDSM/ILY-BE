package com.example.ilybe.domain.review.domain.repository;

import com.example.ilybe.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
