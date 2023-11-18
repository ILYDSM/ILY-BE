package com.example.ilybe.domain.target.presentation.dto;

import com.example.ilybe.domain.target.presentation.dto.request.CreateTargetRequest;
import com.example.ilybe.domain.target.presentation.dto.request.UpdateTargetRequest;
import com.example.ilybe.domain.target.service.CreateTargetService;
import com.example.ilybe.domain.target.service.DeleteTargetService;
import com.example.ilybe.domain.target.service.UpdateTargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/target")
public class TargetController {
    private final CreateTargetService createTargetService;
    private final DeleteTargetService deleteTargetService;
    private final UpdateTargetService updateTargetService;

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
}