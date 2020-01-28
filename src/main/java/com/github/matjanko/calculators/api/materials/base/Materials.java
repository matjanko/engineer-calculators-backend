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

        concretes.add(new ConcreteImpl(ConcreteClass.C12_15));
        concretes.add(new ConcreteImpl(ConcreteClass.C16_20));
        concretes.add(new ConcreteImpl(ConcreteClass.C20_25));
        concretes.add(new ConcreteImpl(ConcreteClass.C25_30));
        concretes.add(new ConcreteImpl(ConcreteClass.C30_37));
        concretes.add(new ConcreteImpl(ConcreteClass.C35_45));
        concretes.add(new ConcreteImpl(ConcreteClass.C40_50));
        concretes.add(new ConcreteImpl(ConcreteClass.C45_55));
        concretes.add(new ConcreteImpl(ConcreteClass.C50_60));
        concretes.add(new ConcreteImpl(ConcreteClass.C55_67));
        concretes.add(new ConcreteImpl(ConcreteClass.C60_75));
        concretes.add(new ConcreteImpl(ConcreteClass.C70_85));
        concretes.add(new ConcreteImpl(ConcreteClass.C80_95));
        concretes.add(new ConcreteImpl(ConcreteClass.C90_105));

        return concretes;
    }
}
