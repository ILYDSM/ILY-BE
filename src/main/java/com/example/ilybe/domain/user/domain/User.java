package com.example.ilybe.domain.user.domain;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.order.domain.Order;
import com.example.ilybe.domain.target.domain.Target;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private List<Target> targets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany
    private List<Meet> bookmarks;

    @Builder
    public User(String email, String password, List<Interest> interests) {
        this.email = email;
        this.password = password;
        this.interests = interests;
        this.point = 0;
    }
}
