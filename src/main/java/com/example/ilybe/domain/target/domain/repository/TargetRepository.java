package com.example.ilybe.domain.target.domain.repository;

import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TargetRepository extends CrudRepository<Target, Long> {
    List<Target> findAllByUserAndIsViewable(User user, Boolean isViewable);
}
