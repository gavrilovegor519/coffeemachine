package com.egor.coffeemachine.repo;

import com.egor.coffeemachine.entity.CoffeeMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeMachineRepo extends JpaRepository<CoffeeMachine, Long> {

}
