package com.example.ilybe.domain.target.service;

import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.target.domain.repository.TargetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteTargetService {
    private final TargetRepository targetRepository;

    @Transactional
    public void execute(Long id) {
        Target target = targetRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        target.setIsViewable(false);
    }
}
