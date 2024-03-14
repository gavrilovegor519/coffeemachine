package com.egor.coffeemachine.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeMachineDto {
    @NotEmpty(message = "Name is required")
    private String name;

    private boolean isEnabled;

    private boolean isBusy;
}
