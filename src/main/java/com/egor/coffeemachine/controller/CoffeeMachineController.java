package com.egor.coffeemachine.controller;

import com.egor.coffeemachine.dto.CoffeeMachineDto;
import com.egor.coffeemachine.service.CoffeeMachineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Add new coffee machine",
            responses = {
                    @ApiResponse(description = "Coffee machine is added",
                            responseCode = "200"),
                    @ApiResponse(responseCode = "409",
                            description = "Duplicate coffee machine"),
                    @ApiResponse(responseCode = "403",
                            description = "User is not authorized")
            })
    public void addCoffeeMachine(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                                 Authentication authentication) {
        coffeeMachineService.addCoffeeMachine(coffeeMachineDto, authentication.getName());
    }

    @PostMapping("/on")
    @Operation(summary = "On the coffee machine",
            responses = {
                    @ApiResponse(description = "Coffee machine is on",
                            responseCode = "200"),
                    @ApiResponse(responseCode = "404",
                            description = "Coffee machine is not found"),
                    @ApiResponse(responseCode = "403",
                            description = "User is not authorized")
            })
    public void on(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                   Authentication authentication) {
        coffeeMachineService.on(coffeeMachineDto.getMachineName(), authentication.getName());
    }

    @PostMapping("/setBusy")
    @Operation(summary = "Busy the coffee machine",
            responses = {
                    @ApiResponse(description = "The coffee machine now is busy",
                            responseCode = "200"),
                    @ApiResponse(responseCode = "404",
                            description = "Coffee machine is not found"),
                    @ApiResponse(responseCode = "403",
                            description = "User is not authorized")
            })
    public void setBusy(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                        Authentication authentication) {
        coffeeMachineService.setBusy(coffeeMachineDto.getMachineName(), authentication.getName());
    }

    @PostMapping("/unsetBusy")
    @Operation(summary = "Not busy the coffee machine",
            responses = {
                    @ApiResponse(description = "The coffee machine now isn't busy",
                            responseCode = "200"),
                    @ApiResponse(responseCode = "404",
                            description = "Coffee machine is not found"),
                    @ApiResponse(responseCode = "403",
                            description = "User is not authorized")
            })
    public void unsetBusy(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                          Authentication authentication) {
        coffeeMachineService.unsetBusy(coffeeMachineDto.getMachineName(), authentication.getName());
    }

    @GetMapping("/state")
    @Operation(summary = "Get coffee machine state",
            responses = {
                    @ApiResponse(description = "Coffee machine state",
                            responseCode = "200"),
                    @ApiResponse(responseCode = "404",
                            description = "Coffee machine is not found"),
                    @ApiResponse(responseCode = "403",
                            description = "User is not authorized")
            })
    public CoffeeMachineDto getState(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                                     Authentication authentication) {
        return coffeeMachineService.getState(coffeeMachineDto.getMachineName(), authentication.getName());
    }

    @PostMapping("/off")
    @Operation(summary = "Off the coffee machine",
            responses = {
                    @ApiResponse(description = "Coffee machine is off",
                            responseCode = "200"),
                    @ApiResponse(responseCode = "404",
                            description = "Coffee machine is not found"),
                    @ApiResponse(responseCode = "403",
                            description = "User is not authorized")
            })
    public void off(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                    Authentication authentication) {
        coffeeMachineService.off(coffeeMachineDto.getMachineName(), authentication.getName());
    }

    @GetMapping("/all")
    @Operation(summary = "Get all coffee machines",
            responses = {
                    @ApiResponse(description = "Coffee machines",
                            responseCode = "200"),
                    @ApiResponse(responseCode = "403",
                            description = "User is not authorized")
            })
    public List<CoffeeMachineDto> getAll(Authentication authentication) {
        return coffeeMachineService.getAll(authentication.getName());
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete coffee machine",
            responses = {
                    @ApiResponse(description = "The coffee machine now is deleted",
                            responseCode = "200"),
                    @ApiResponse(responseCode = "404",
                            description = "Coffee machine is not found"),
                    @ApiResponse(responseCode = "403",
                            description = "User is not authorized")
            })
    public void deleteMachine(@RequestBody @Valid CoffeeMachineDto coffeeMachineDto,
                              Authentication authentication) {
        coffeeMachineService.deleteMachine(coffeeMachineDto.getMachineName(), authentication.getName());
    }
}
