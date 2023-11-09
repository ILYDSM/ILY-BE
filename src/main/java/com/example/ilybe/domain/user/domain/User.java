package com.example.ilybe.domain.user.domain;

import com.example.ilybe.domain.order.domain.Order;
import com.example.ilybe.domain.target.domain.Target;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
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
    private Long point;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Target> targets;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;
}
