package com.egor.coffeemachine.controller;

import com.egor.coffeemachine.dto.CoffeeMachineDto;
import com.egor.coffeemachine.service.CoffeeMachineService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/coffee")
@PreAuthorize("isAuthenticated()")
@AllArgsConstructor
public class CoffeeMachineController {
    private CoffeeMachineService coffeeMachineService;

    @PostMapping("/add")
    public void addCoffeeMachine(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                                 Authentication authentication) {
        coffeeMachineService.addCoffeeMachine(coffeeMachineDto, authentication.getName());
    }

    @PostMapping("/on")
    public void on(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                   Authentication authentication) {
        coffeeMachineService.on(coffeeMachineDto.getMachineName(), authentication.getName());
    }

    @PostMapping("/setBusy")
    public void setBusy(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                        Authentication authentication) {
        coffeeMachineService.setBusy(coffeeMachineDto.getMachineName(), authentication.getName());
    }

    @PostMapping("/unsetBusy")
    public void unsetBusy(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                          Authentication authentication) {
        coffeeMachineService.unsetBusy(coffeeMachineDto.getMachineName(), authentication.getName());
    }

    @GetMapping("/state")
    public CoffeeMachineDto getState(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                                     Authentication authentication) {
        return coffeeMachineService.getState(coffeeMachineDto.getMachineName(), authentication.getName());
    }

    @PostMapping("/off")
    public void off(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                    Authentication authentication) {
        coffeeMachineService.off(coffeeMachineDto.getMachineName(), authentication.getName());
    }

    @GetMapping("/all")
    public List<CoffeeMachineDto> getAll(Authentication authentication) {
        return coffeeMachineService.getAll(authentication.getName());
    }

    @DeleteMapping("/delete")
    public void deleteMachine(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                              Authentication authentication) {
        coffeeMachineService.deleteMachine(coffeeMachineDto.getMachineName(), authentication.getName());
    }
}
