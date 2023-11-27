package com.example.ilybe.domain.target.presentation.dto.response;

import com.example.ilybe.domain.meet.domain.Meet;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryTargetsResponse {
    private final Long id;
    private final String content;
    private final Boolean isAchieved;
    private final String theme;
    private final Long meetId;

    public QueryTargetsResponse(Long id, String content, Boolean isAchieved, String theme, Meet meet) {
        this.id = id;
        this.content = content;
        this.isAchieved = isAchieved;
        this.theme = theme;
        if (meet == null) {
            this.meetId = null;
        } else {
            this.meetId = meet.getId();
        }
    }
}
