package com.example.ilybe.domain.record.domain;

import com.example.ilybe.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Entity
public class Record {
    @Id
    private Long id;

    private LocalDate date;

    private Integer count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Builder
    public Record(LocalDate date, User user) {
        this.date = date;
        this.count = 0;
        this.user = user;
    }
}
