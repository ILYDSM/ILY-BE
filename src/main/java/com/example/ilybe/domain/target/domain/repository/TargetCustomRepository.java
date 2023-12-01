package com.example.ilybe.domain.target.domain.repository;

import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.user.domain.User;

import java.util.List;

public interface TargetCustomRepository {
    List<Target> findAllByUserAndIsViewable(User user, Boolean isViewable);
}
