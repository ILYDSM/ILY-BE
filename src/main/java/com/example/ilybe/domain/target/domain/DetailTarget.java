package com.example.ilybe.domain.target.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class DetailTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Boolean isAchieved;

    @ManyToOne
    @JoinColumn(name = "sub_target_id", nullable = false)
    private SubTarget subTarget;
}
