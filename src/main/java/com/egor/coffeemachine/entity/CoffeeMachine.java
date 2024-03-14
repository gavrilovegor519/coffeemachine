package com.egor.coffeemachine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "coffee_machine")
@Getter
@Setter
public class CoffeeMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "isEnabled")
    private boolean isEnabled;

    @Column(name = "isBusy")
    private boolean isBusy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoffeeMachine that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
