package com.example.ilybe.domain.board.domain.repository;

import com.example.ilybe.domain.board.domain.Board;
import com.example.ilybe.domain.meet.domain.Meet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<List<Board>> findByMeet(Meet meet);
}
