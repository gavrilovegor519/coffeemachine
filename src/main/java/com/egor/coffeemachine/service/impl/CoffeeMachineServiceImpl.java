package com.egor.coffeemachine.service.impl;

import com.egor.coffeemachine.dto.CoffeeMachineDto;
import com.egor.coffeemachine.entity.CoffeeMachine;
import com.egor.coffeemachine.entity.User;
import com.egor.coffeemachine.exception.CoffeeMachineIsExistException;
import com.egor.coffeemachine.exception.CoffeeMachineIsNotExistException;
import com.egor.coffeemachine.exception.UserNotFoundException;
import com.egor.coffeemachine.mapper.CoffeeMachineMapper;
import com.egor.coffeemachine.repo.CoffeeMachineRepo;
import com.egor.coffeemachine.repo.UserRepo;
import com.egor.coffeemachine.service.CoffeeMachineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoffeeMachineServiceImpl implements CoffeeMachineService {
    private final CoffeeMachineRepo coffeeMachineRepo;
    private final CoffeeMachineMapper coffeeMachineMapper;
    private final UserRepo userRepo;

    @Override
    public void addCoffeeMachine(CoffeeMachineDto coffeeMachineDto, String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));

        if (user.getCoffeeMachines().stream().anyMatch(
                m -> m.getMachineName().equals(coffeeMachineDto.getMachineName()))) {
            throw new CoffeeMachineIsExistException(
                    "Coffee machine with name " + coffeeMachineDto.getMachineName() + " already exists");
        }

        CoffeeMachine coffeeMachine = coffeeMachineMapper.map(coffeeMachineDto);
        coffeeMachine.setUser(user);
        coffeeMachineRepo.save(coffeeMachine);
    }

    @Override
    public void on(String machine, String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));

        CoffeeMachine coffeeMachine = user.getCoffeeMachines().stream()
                .filter(m -> m.getMachineName().equals(machine))
                        .findFirst().orElseThrow(
                                () -> new CoffeeMachineIsNotExistException(
                                        "Coffee machine with name " + machine + " not found"));

        coffeeMachine.setEnabled(true);
        coffeeMachineRepo.save(coffeeMachine);
    }

    @Override
    public void setBusy(String machine, String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));

        CoffeeMachine coffeeMachine = user.getCoffeeMachines().stream()
                .filter(m -> m.getMachineName().equals(machine))
                .findFirst().orElseThrow(
                        () -> new CoffeeMachineIsNotExistException(
                                "Coffee machine with name " + machine + " not found"));

        coffeeMachine.setBusy(true);
        coffeeMachineRepo.save(coffeeMachine);
    }

    @Override
    public void unsetBusy(String machine, String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));

        CoffeeMachine coffeeMachine = user.getCoffeeMachines().stream()
                .filter(m -> m.getMachineName().equals(machine))
                .findFirst().orElseThrow(
                        () -> new CoffeeMachineIsNotExistException(
                                "Coffee machine with name " + machine + " not found"));

        coffeeMachine.setBusy(false);
        coffeeMachineRepo.save(coffeeMachine);
    }

    @Override
    public CoffeeMachineDto getState(String machine, String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));

        CoffeeMachine coffeeMachine = user.getCoffeeMachines().stream()
                .filter(m -> m.getMachineName().equals(machine))
                .findFirst().orElseThrow(
                        () -> new CoffeeMachineIsNotExistException(
                                "Coffee machine with name " + machine + " not found"));

        return coffeeMachineMapper.map(coffeeMachine);
    }

    @Override
    public void off(String machine, String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));

        CoffeeMachine coffeeMachine = user.getCoffeeMachines().stream()
                .filter(m -> m.getMachineName().equals(machine))
                .findFirst().orElseThrow(
                        () -> new CoffeeMachineIsNotExistException(
                                "Coffee machine with name " + machine + " not found"));

        coffeeMachine.setEnabled(false);
        coffeeMachineRepo.save(coffeeMachine);
    }

    @Override
    public List<CoffeeMachineDto> getAll(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));

        return coffeeMachineMapper.map(user.getCoffeeMachines());
    }

    @Override
    public void deleteMachine(String machine, String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));

        user.getCoffeeMachines().removeIf(m -> m.getMachineName().equals(machine));
        userRepo.save(user);
    }
}
