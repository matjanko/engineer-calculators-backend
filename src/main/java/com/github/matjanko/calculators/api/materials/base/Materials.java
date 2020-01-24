package com.github.matjanko.calculators.api.materials.base;

import com.github.matjanko.calculators.api.materials.concrete.Concrete;
import com.github.matjanko.calculators.api.materials.concrete.impl.ConcreteImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author matjanko
 *
 */


public class Materials {

    public static List<Concrete> getConcretes() {
        List<Concrete> concretes = new LinkedList<>();

        concretes.add(new ConcreteImpl(12, 15));
        concretes.add(new ConcreteImpl(16, 20));
        concretes.add(new ConcreteImpl(20, 25));
        concretes.add(new ConcreteImpl(25, 30));
        concretes.add(new ConcreteImpl(30, 37));
        concretes.add(new ConcreteImpl(35, 45));
        concretes.add(new ConcreteImpl(40, 50));
        concretes.add(new ConcreteImpl(45, 55));
        concretes.add(new ConcreteImpl(50, 60));
        concretes.add(new ConcreteImpl(55, 67));
        concretes.add(new ConcreteImpl(60, 75));
        concretes.add(new ConcreteImpl(70, 85));
        concretes.add(new ConcreteImpl(80, 95));
        concretes.add(new ConcreteImpl(90, 105));

        return concretes;
    }
}
