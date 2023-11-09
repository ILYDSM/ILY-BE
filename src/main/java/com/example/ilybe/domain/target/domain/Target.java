package com.example.ilybe.domain.target.domain;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.theme.domain.Theme;
import com.example.ilybe.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
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

    private String cycle;

    @Column(nullable = false)
    private Boolean achieved;

    @OneToOne
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    @OneToMany(mappedBy = "target", cascade = CascadeType.ALL)
    private List<SubTarget> subTargets;

    @OneToOne
    @JoinColumn(name = "meet_id")
    private Meet meet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
