package com.example.ilybe.domain.target.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class CreateTargetRequest {
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

    private String theme;

    private Integer themePrice;

    private Long meetId;

//    @NotNull
//    private String firstSubTarget;
//
//    @NotNull
//    private List<String> firstDetailTarget;
//
//    @NotNull
//    private String secondSubTarget;
//
//    @NotNull
//    private List<String> secondSubSubTarget;
//
//    @NotNull
//    private String thirdSubTarget;
//
//    @NotNull
//    private List<String> thirdDetailTarget;
//
//    @NotNull
//    private String fourthSubTarget;
//
//    @NotNull
//    private List<String> fourthDetailTarget;
//
//    @NotNull
//    private String fifthSubTarget;
//
//    @NotNull
//    private List<String> fifthDetailTarget;
//
//    @NotNull
//    private String sixthSubTarget;
//
//    @NotNull
//    private List<String> sixthDetailTarget;
//
//    @NotNull
//    private String seventhSubTarget;
//
//    @NotNull
//    private List<String> seventhDetailTarget;
//
//    @NotNull
//    private String eighthSubTarget;
//
//    @NotNull
//    private List<String> eighthDetailTarget;
}
