package com.example.ilybe.domain.user.domain;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.target.domain.Target;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String nickname;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 60)
    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Interest> interests;

    @Column(nullable = false)
    private Integer point;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Target> targets = new ArrayList<>();

    @OneToMany
    private List<Meet> bookmarks;

    @Builder
    public User(String nickname, String email, String password, List<Interest> interests) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.interests = interests;
        this.point = 0;
    }

    @Builder
    public User(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public void minusPoint(Integer price) {
        this.point -= price;
    }
}
