package com.example.ilybe.domain.meet.domain;

import com.example.ilybe.domain.target.domain.Target;
import com.example.ilybe.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Type.class)
    private List<Type> type;

    private Long personnel;

    @ManyToMany
    private List<User> users;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User manager;

    @OneToOne(mappedBy = "meet", cascade = CascadeType.ALL)
    private Target target;

    public void meetUpdate(String title, String content, List<Type> type){
        this.title = title;
        this.content = content;
        this.type = type;
    }
}
