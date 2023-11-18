package com.example.ilybe.domain.target.domain.repository;

import com.example.ilybe.domain.target.domain.DetailTarget;
import com.example.ilybe.domain.target.domain.SubTarget;
import org.springframework.data.repository.CrudRepository;

public interface DetailTargetRepository extends CrudRepository<DetailTarget, Long> {
    void deleteAllBySubTarget(SubTarget subTarget);
}
