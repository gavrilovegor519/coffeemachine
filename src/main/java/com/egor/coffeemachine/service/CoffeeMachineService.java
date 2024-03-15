package com.egor.coffeemachine.service;

import com.egor.coffeemachine.dto.CoffeeMachineDto;

import java.util.List;

public interface CoffeeMachineService {
    void addCoffeeMachine(CoffeeMachineDto coffeeMachineDto, String username);
    void on(String machine, String username);
    void setBusy(String machine, String username);
    void unsetBusy(String machine, String username);
    CoffeeMachineDto getState(String machine, String username);
    void off(String machine, String username);
    List<CoffeeMachineDto> getAll(String username);
    void deleteMachine(String machine, String username);
}
