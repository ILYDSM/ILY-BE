package com.example.ilybe.domain.target.service;

import com.example.ilybe.domain.target.domain.DetailTarget;
import com.example.ilybe.domain.target.domain.SubTarget;
import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.target.domain.repository.DetailTargetRepository;
import com.example.ilybe.domain.target.domain.repository.SubTargetRepository;
import com.example.ilybe.domain.target.domain.repository.TargetRepository;
import com.example.ilybe.domain.target.presentation.dto.request.UpdateTargetRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UpdateTargetService {
    private final TargetRepository targetRepository;
    private final SubTargetRepository subTargetRepository;
    private final DetailTargetRepository detailTargetRepository;

    @Transactional
    public void execute(Long id, UpdateTargetRequest request) {
        if (request.getSubTargets().size() != 8 || request.getDetailTargets().size() != 64)
            throw new IllegalArgumentException();

        Target target = targetRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        List<SubTarget> subTargets = subTargetRepository.findAllByTarget(target);

        for (SubTarget subTarget : subTargets) {
            detailTargetRepository.deleteAllBySubTarget(subTarget);
            subTargetRepository.delete(subTarget);
        }

        target.setContent(request.getTarget());
        target.setCycleDate(request.getCycleDate());
        target.setCycleTerm(request.getCycleTerm());
        target.setCycleCount(request.getCycleCount());

        for (int i = 0; i <= 7; i++) {
            SubTarget subTarget = subTargetRepository.save(
                    SubTarget.builder()
                            .target(target)
                            .content(request.getSubTargets().get(i))
                            .build());
            int count = i * 8;
            for (int j = count; j <= count + 7; j++) {
                detailTargetRepository.save(
                        DetailTarget.builder()
                                .content(request.getDetailTargets().get(j))
                                .subTarget(subTarget)
                                .build()
                );
            }
        }
    }
}

