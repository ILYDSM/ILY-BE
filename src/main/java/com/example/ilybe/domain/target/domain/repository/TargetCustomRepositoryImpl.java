package com.example.ilybe.domain.target.domain.repository;

import static com.example.ilybe.domain.target.domain.QTarget.target;
import static com.example.ilybe.domain.meet.domain.QMeet.meet;
import static com.example.ilybe.domain.target.domain.QSubTarget.subTarget;
import static com.example.ilybe.domain.target.domain.QDetailTarget.detailTarget;

import com.example.ilybe.domain.target.domain.DetailTarget;
import com.example.ilybe.domain.target.domain.SubTarget;
import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TargetCustomRepositoryImpl implements TargetCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Target> findAllByUserAndIsViewable(User user, Boolean isViewable) {
        return jpaQueryFactory.selectFrom(target)
                .leftJoin(meet)
                .on(target.meet.eq(meet))
                .where(target.user.eq(user).and(target.isViewable.isTrue()))
                .fetch();
    }
}
