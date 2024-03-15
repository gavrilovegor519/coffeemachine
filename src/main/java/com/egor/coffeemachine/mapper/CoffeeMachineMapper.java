package com.egor.coffeemachine.mapper;

import com.egor.coffeemachine.dto.CoffeeMachineDto;
import com.egor.coffeemachine.entity.CoffeeMachine;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoffeeMachineMapper {
    CoffeeMachine map(CoffeeMachineDto coffeeMachineDto);
    CoffeeMachineDto map(CoffeeMachine coffeeMachine);
    List<CoffeeMachineDto> map(List<CoffeeMachine> coffeeMachines);
}
