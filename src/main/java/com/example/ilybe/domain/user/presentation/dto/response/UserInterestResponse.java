package com.example.ilybe.domain.user.presentation.dto.response;

import com.example.ilybe.domain.user.domain.Interest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class UserInterestResponse {
    private final List<Interest> interests;
}
