package com.example.ilybe.domain.target.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id", nullable = false)
    private Target target;

    private LocalDate achievedAt;

    @OneToMany(mappedBy = "subTarget", cascade = CascadeType.ALL)
    private List<DetailTarget> detailTargets = new ArrayList<>();

    public Boolean isAchieved() {
        return achievedAt != null;
    }

    @Builder
    public SubTarget(String content, Target target) {
        this.target = target;
        this.content = content;
    }

    public void updateAchievedAt(LocalDate achievedAt) {
        this.achievedAt = achievedAt;
    }
}
