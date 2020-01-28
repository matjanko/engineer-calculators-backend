package com.github.matjanko.calculators.api.materials.base;

import com.github.matjanko.calculators.api.materials.concrete.Concrete;
import com.github.matjanko.calculators.api.materials.concrete.ConcreteClass;
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

        for (ConcreteClass concreteClass : ConcreteClass.values()) {
            concretes.add(new ConcreteImpl(concreteClass));
        }

        return concretes;
    }
}
