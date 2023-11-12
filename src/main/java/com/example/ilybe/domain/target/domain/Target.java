package com.example.ilybe.domain.target.domain;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.user.domain.User;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Target {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer cycleCount;

    @Column(nullable = false)
    private Integer cycleTerm;

    @Column(nullable = false)
    private LocalDate cycleDate;
    private LocalDate achievedAt;

    @Column(nullable = false)
    @ColumnDefault("'Gray'")
    private String theme;

    @OneToMany(mappedBy = "target", cascade = CascadeType.ALL)
    private List<SubTarget> subTargets = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "meet_id")
    private Meet meet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Boolean isAchieved() {
        return achievedAt != null;
    }
}
