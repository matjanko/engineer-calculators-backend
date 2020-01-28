package com.github.matjanko.calculators.api.materials.base;

import com.github.matjanko.calculators.api.materials.concrete.Concrete;
import com.github.matjanko.calculators.api.materials.concrete.ConcreteClass;
import com.github.matjanko.calculators.api.materials.concrete.impl.ConcreteImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matjanko
 *
 */


public class Materials {

    public static List<Concrete> getConcretes() {
        return Stream.of(ConcreteClass.values())
                .map(ConcreteImpl::new)
                .collect(Collectors.toList());
    }
}
