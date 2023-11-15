package com.example.ilybe.domain.review.domain;

import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String writerName;

    @Column(length = 500, nullable = false)
    private String content;

    @NotNull
    private LocalDateTime createDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "meet_id")
    private Meet meet;

    public void reviewUpdate(String content, LocalDateTime createDate) {
        this.content = content;
        this.createDate = createDate;
    }
}
