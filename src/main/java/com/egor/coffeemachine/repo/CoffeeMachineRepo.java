package com.egor.coffeemachine.repo;

import com.egor.coffeemachine.entity.CoffeeMachine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoffeeMachineRepo extends JpaRepository<CoffeeMachine, Long> {
    Optional<CoffeeMachine> findByName(String name);
}
