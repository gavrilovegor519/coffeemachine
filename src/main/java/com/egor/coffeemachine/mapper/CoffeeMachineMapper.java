package com.egor.coffeemachine.mapper;

import com.egor.coffeemachine.dto.CoffeeMachineDto;
import com.egor.coffeemachine.entity.CoffeeMachine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMachineMapper {
    CoffeeMachine map(CoffeeMachineDto coffeeMachineDto);
    CoffeeMachineDto map(CoffeeMachine coffeeMachine);
}
