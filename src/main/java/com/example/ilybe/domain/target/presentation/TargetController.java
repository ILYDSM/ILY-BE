package com.example.ilybe.domain.target.presentation;

import com.example.ilybe.domain.target.presentation.dto.request.CreateTargetRequest;
import com.example.ilybe.domain.target.presentation.dto.request.UpdateTargetRequest;
import com.example.ilybe.domain.target.presentation.dto.response.QuerySubTargetResponse;
import com.example.ilybe.domain.target.presentation.dto.response.QueryTargetInfoResponse;
import com.example.ilybe.domain.target.presentation.dto.response.QueryTargetsResponse;
import com.example.ilybe.domain.target.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/target")
public class TargetController {
    private final CreateTargetService createTargetService;
    private final DeleteTargetService deleteTargetService;
    private final UpdateTargetService updateTargetService;
    private final QueryTargetsService queryTargetsService;
    private final QueryTargetInfoService queryTargetInfoService;
    private final QuerySubTargetInfoService querySubTargetInfoService;
    private final AchieveDetailService achieveDetailService;

    @PostMapping
    public void createTarget(@RequestBody @Valid CreateTargetRequest request) {
        createTargetService.execute(request);
    }

    @DeleteMapping("/{target-id}")
    public void deleteTarget(@PathVariable("target-id") Long id) {
        deleteTargetService.execute(id);
    }

    @PatchMapping("/{target-id}")
    public void updateTarget(@PathVariable("target-id") Long id, @RequestBody @Valid UpdateTargetRequest request) {
        updateTargetService.execute(id, request);
    }

    @GetMapping
    public List<QueryTargetsResponse> queryTargets() {
        return queryTargetsService.execute();
    }

    @GetMapping("/{target-id}")
    public QueryTargetInfoResponse queryTargetInfo(@PathVariable("target-id") Long id) {
        return queryTargetInfoService.execute(id);
    }

    @GetMapping("/sub/{target-id}")
    public QuerySubTargetResponse querySubTarget(@PathVariable("target-id") Long id) {
        return querySubTargetInfoService.execute(id);
    }

    @PatchMapping("/detail/{target-id}")
    public void achiveTarget(@PathVariable("target-id") Long id) {
        achieveDetailService.execute(id);
    }
}