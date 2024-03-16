package com.egor.coffeemachine.service;

import com.egor.coffeemachine.dto.CoffeeMachineDto;

import java.util.List;

/**
 * Coffee machine service layer.
 * @author Egor Gavrilov (gavrilovegor519@gmail.com)
 */
public interface CoffeeMachineService {
    /**
     * Add a new coffee machine.
     * @param coffeeMachineDto Coffee machine data
     * @param username Username
     */
    void addCoffeeMachine(CoffeeMachineDto coffeeMachineDto, String username);

    /**
     * On a coffee machine.
     * @param machine Machine name
     * @param username Username
     */
    void on(String machine, String username);

    /**
     * Off a coffee machine.
     * @param machine Machine name
     * @param username Username
     */
    void setBusy(String machine, String username);

    /**
     * Unset busy state of a coffee machine.
     * @param machine Machine name
     * @param username Username
     */
    void unsetBusy(String machine, String username);

    /**
     * Get the states of a coffee machine.
     * @param machine Machine name
     * @param username Username
     * @return List of states of a coffee machine
     */
    CoffeeMachineDto getState(String machine, String username);

    /**
     * Off a coffee machine.
     * @param machine Machine name
     * @param username Username
     */
    void off(String machine, String username);

    /**
     * Get all coffee machines.
     * @param username Username
     * @return List of coffee machines
     */
    List<CoffeeMachineDto> getAll(String username);

    /**
     * Delete a coffee machine.
     * @param machine Machine name
     * @param username Username
     */
    void deleteMachine(String machine, String username);
}
