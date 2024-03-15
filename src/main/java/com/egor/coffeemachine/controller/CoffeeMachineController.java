package com.egor.coffeemachine.controller;

import com.egor.coffeemachine.dto.CoffeeMachineDto;
import com.egor.coffeemachine.service.CoffeeMachineService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1.0/coffee")
@AllArgsConstructor
public class CoffeeMachineController {
    private CoffeeMachineService coffeeMachineService;

    @PostMapping("/add")
    public void addCoffeeMachine(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto) {
        coffeeMachineService.addCoffeeMachine(coffeeMachineDto);
    }

    @PostMapping("/on")
    public void on(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto) {
        coffeeMachineService.on(coffeeMachineDto.getMachineName());
    }

    @PostMapping("/setBusy")
    public void setBusy(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto) {
        coffeeMachineService.setBusy(coffeeMachineDto.getMachineName());
    }

    @PostMapping("/unsetBusy")
    public void unsetBusy(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto) {
        coffeeMachineService.unsetBusy(coffeeMachineDto.getMachineName());
    }

    @GetMapping("/state")
    public CoffeeMachineDto getState(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto) {
        return coffeeMachineService.getState(coffeeMachineDto.getMachineName());
    }

    @PostMapping("/off")
    public void off(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto) {
        coffeeMachineService.off(coffeeMachineDto.getMachineName());
    }
}
