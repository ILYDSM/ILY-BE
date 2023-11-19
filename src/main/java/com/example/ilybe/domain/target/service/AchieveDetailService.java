package com.example.ilybe.domain.target.service;

import com.example.ilybe.domain.record.domain.Record;
import com.example.ilybe.domain.record.domain.repository.RecordRepository;
import com.example.ilybe.domain.target.domain.DetailTarget;
import com.example.ilybe.domain.target.domain.SubTarget;
import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.target.domain.repository.DetailTargetRepository;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class AchieveDetailService {
    private final DetailTargetRepository detailTargetRepository;
    private final UserFacade userFacade;
    private final RecordRepository recordRepository;

    @Transactional
    public void execute(Long id) {
        LocalDate today = LocalDate.now();
        User user = userFacade.getCurrentUser();
        DetailTarget detailTarget = detailTargetRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        detailTarget.setAchievedAt(today);
        SubTarget subTarget = detailTarget.getSubTarget();
        if (subTarget.getDetailTargets().stream().filter(DetailTarget::isAchieved).toList().size() == 8) {
            subTarget.setAchievedAt(today);
            Target target = subTarget.getTarget();
            if (target.getSubTargets().stream().filter(SubTarget::isAchieved).toList().size() == 8) {
                target.setAchievedAt(today);
                user.setPoint(user.getPoint() + 10);
            }
        }

        Record record = recordRepository.findByDateAndUser(today, user).orElse(new Record(today, user));
        record.setCount(record.getCount() + 1);
        recordRepository.save(record);
    }
}
