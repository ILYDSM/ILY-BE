package com.example.ilybe.domain.meet.domain.repository;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.meet.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeetRepository extends JpaRepository<Meet, Long> {
    @Query("SELECT DISTINCT t FROM Meet m JOIN m.type t")
    List<Type> findAllType();

    List<Meet> findByTypeIn(List<Type> type);

    Page<Meet> findByType(Type type, Pageable pageable);
}
