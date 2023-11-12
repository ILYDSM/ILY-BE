package com.example.ilybe.domain.user.domain;

import com.example.ilybe.domain.target.domain.Target;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Builder
    public User(String email, String password, List<Interest> interests) {
        this.email = email;
        this.password = password;
        this.interests = interests;
        this.point = 0;
    }

    public void minusPoint(Integer price) {
        this.point -= price;
    }
}
