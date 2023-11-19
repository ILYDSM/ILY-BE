package com.example.ilybe.domain.user.presentation.dto.request;

import com.example.ilybe.domain.user.domain.Interest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class UpdateInterestRequest {
    private List<Interest> interests;
}
