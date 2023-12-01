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
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Target {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Integer cycleCount;

    private Integer cycleTerm;

    private LocalDate cycleDate;
    private LocalDate achievedAt;

    private Boolean isViewable;

    @Column(nullable = false)
    @ColumnDefault("Gray")
    private String theme;

    @OneToMany(mappedBy = "target", cascade = CascadeType.ALL)
    private List<SubTarget> subTargets = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meet_id")
    private Meet meet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Boolean isAchieved() {
        return achievedAt != null;
    }

    @Builder
    public Target(String content, Integer cycleCount, Integer cycleTerm, LocalDate cycleDate, String theme, User user) {
        this.content = content;
        this.cycleCount = cycleCount;
        this.cycleTerm = cycleTerm;
        this.cycleDate = cycleDate;
        this.theme = theme;
        this.user = user;
        this.isViewable = true;
    }
}
