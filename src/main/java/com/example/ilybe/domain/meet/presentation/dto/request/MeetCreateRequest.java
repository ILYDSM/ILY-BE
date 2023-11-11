package com.example.ilybe.domain.meet.presentation.dto.request;

import com.example.ilybe.domain.meet.domain.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
public class MeetCreateRequest {
    @NotNull(message = "제목을 입력해주세요.")
    private String title;

    @NotNull(message = "설명을 입력해주세요.")
    private String content;

    @NotNull(message = "타입을 선택해주세요.")
    private List<Type> type;

    private Long personnel;
}
