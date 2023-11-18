package com.example.ilybe.domain.record.domain.repository;

import com.example.ilybe.domain.record.domain.Record;
import com.example.ilybe.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RecordRepository extends CrudRepository<Record, Long> {
    Optional<Record> findByDateAndUser(LocalDate date, User user);
}
