package com.example.ilybe.domain.target.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class UpdateTargetRequest {
    @NotNull
    private String target;

    @NotNull
    private Integer cycleCount;

    @NotNull
    private Integer cycleTerm;

    @NotNull
    private LocalDate cycleDate;

    @NotNull
    private List<String> subTargets;

    @NotNull
    private List<String> detailTargets;
}
