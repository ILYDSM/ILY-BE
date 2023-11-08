package com.example.ilybe.domain.target.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class SubTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id", nullable = false)
    private Target target;

    @Column(nullable = false)
    private Boolean isAchieved;

    @OneToMany(mappedBy = "subTarget", cascade = CascadeType.ALL)
    private List<SubTarget> subTargets;
}
