package com.egor.coffeemachine.service.impl;

import com.egor.coffeemachine.dto.CoffeeMachineDto;
import com.egor.coffeemachine.entity.CoffeeMachine;
import com.egor.coffeemachine.exception.CoffeeMachineIsExistException;
import com.egor.coffeemachine.exception.CoffeeMachineIsNotExistException;
import com.egor.coffeemachine.mapper.CoffeeMachineMapper;
import com.egor.coffeemachine.repo.CoffeeMachineRepo;
import com.egor.coffeemachine.service.CoffeeMachineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoffeeMachineServiceImpl implements CoffeeMachineService {
    private final CoffeeMachineRepo coffeeMachineRepo;
    private final CoffeeMachineMapper coffeeMachineMapper;

    @Override
    public void addCoffeeMachine(CoffeeMachineDto coffeeMachineDto) {
        if (coffeeMachineRepo.existsByMachineName(coffeeMachineDto.getMachineName())) {
            throw new CoffeeMachineIsExistException(
                    "Coffee machine with name " + coffeeMachineDto.getMachineName() + " already exists");
        }

        CoffeeMachine coffeeMachine = coffeeMachineMapper.map(coffeeMachineDto);
        coffeeMachineRepo.save(coffeeMachine);
    }

    @Override
    public void on(String machine) {
        CoffeeMachine coffeeMachine = coffeeMachineRepo.findByMachineName(machine)
                .orElseThrow(() -> new CoffeeMachineIsNotExistException(
                        "Coffee machine with name " + machine + " does not exist"));

        coffeeMachine.setEnabled(true);
        coffeeMachineRepo.save(coffeeMachine);
    }

    @Override
    public void setBusy(String machine) {
        CoffeeMachine coffeeMachine = coffeeMachineRepo.findByMachineName(machine)
                .orElseThrow(() -> new CoffeeMachineIsNotExistException(
                        "Coffee machine with name " + machine + " does not exist"));

        coffeeMachine.setBusy(true);
        coffeeMachineRepo.save(coffeeMachine);
    }

    @Override
    public void unsetBusy(String machine) {
        CoffeeMachine coffeeMachine = coffeeMachineRepo.findByMachineName(machine)
                .orElseThrow(() -> new CoffeeMachineIsNotExistException(
                        "Coffee machine with name " + machine + " does not exist"));

        coffeeMachine.setBusy(false);
        coffeeMachineRepo.save(coffeeMachine);
    }

    @Override
    public CoffeeMachineDto getState(String machine) {
        CoffeeMachine coffeeMachine = coffeeMachineRepo.findByMachineName(machine)
                .orElseThrow(() -> new CoffeeMachineIsNotExistException(
                        "Coffee machine with name " + machine + " does not exist"));

        return coffeeMachineMapper.map(coffeeMachine);
    }

    @Override
    public void off(String machine) {
        CoffeeMachine coffeeMachine = coffeeMachineRepo.findByMachineName(machine)
                .orElseThrow(() -> new CoffeeMachineIsNotExistException(
                        "Coffee machine with name " + machine + " does not exist"));

        coffeeMachine.setEnabled(false);
        coffeeMachineRepo.save(coffeeMachine);
    }
}
