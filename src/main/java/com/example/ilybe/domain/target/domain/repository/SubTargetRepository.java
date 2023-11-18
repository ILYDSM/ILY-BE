package com.example.ilybe.domain.target.domain.repository;

import com.example.ilybe.domain.target.domain.SubTarget;
import com.example.ilybe.domain.target.domain.Target;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubTargetRepository extends CrudRepository<SubTarget, Long> {
    List<SubTarget> findAllByTarget(Target target);
}
