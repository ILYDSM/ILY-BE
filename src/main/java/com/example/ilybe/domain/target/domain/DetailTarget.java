package com.example.ilybe.domain.target.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DetailTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    private LocalDate achievedAt;

    @ManyToOne
    @JoinColumn(name = "sub_target_id", nullable = false)
    private SubTarget subTarget;

    public Boolean isAchieved() {
        return achievedAt != null;
    }

    @Builder
    public DetailTarget(String content, SubTarget subTarget) {
        this.content = content;
        this.subTarget = subTarget;
    }

    public void updateAchievedAt(LocalDate achievedAt) {
        this.achievedAt = achievedAt;
    }
}
