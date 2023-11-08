package com.example.ilybe.domain.theme.domain;

import com.example.ilybe.domain.order.domain.Order;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    private List<Order> orders;
}
