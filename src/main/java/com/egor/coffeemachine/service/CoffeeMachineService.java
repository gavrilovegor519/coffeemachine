package com.egor.coffeemachine.service;

import com.egor.coffeemachine.dto.CoffeeMachineDto;

public interface CoffeeMachineService {
    void addCoffeeMachine (CoffeeMachineDto coffeeMachineDto);
    void on(String machine);
    void setBusy(String machine);
    void unsetBusy(String machine);
    CoffeeMachineDto getState(String machine);
    void off(String machine);
}
