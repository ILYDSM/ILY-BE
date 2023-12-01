package com.example.ilybe.domain.target.domain.repository;

import com.example.ilybe.domain.target.domain.Target;
import org.springframework.data.repository.CrudRepository;


public interface TargetRepository extends CrudRepository<Target, Long>, TargetCustomRepository {
}
