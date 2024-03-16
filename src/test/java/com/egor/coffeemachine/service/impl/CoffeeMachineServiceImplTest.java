package com.egor.coffeemachine.service.impl;

import com.egor.coffeemachine.dto.CoffeeMachineDto;
import com.egor.coffeemachine.entity.CoffeeMachine;
import com.egor.coffeemachine.entity.User;
import com.egor.coffeemachine.exception.CoffeeMachineIsExistException;
import com.egor.coffeemachine.repo.CoffeeMachineRepo;
import com.egor.coffeemachine.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CoffeeMachineServiceImplTest {
    @Mock
    private CoffeeMachineRepo coffeeMachineRepo;

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private CoffeeMachineServiceImpl coffeeMachineService;

    @Test
    void addExistingCoffeeMachine () {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.setMachineName("test");

        User user = new User();
        user.getCoffeeMachines().add(coffeeMachine);

        CoffeeMachineDto coffeeMachineDto = new CoffeeMachineDto();
        coffeeMachineDto.setMachineName("test");

        when(userRepo.findByUsername(any())).thenReturn(Optional.of(user));

        assertThrows(CoffeeMachineIsExistException.class,
                () -> coffeeMachineService.addCoffeeMachine(coffeeMachineDto, any()));
    }
}