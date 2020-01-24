package com.github.matjanko.calculators.api.materials.concrete.impl;

import com.github.matjanko.calculators.api.materials.base.Materials;
import com.github.matjanko.calculators.api.materials.concrete.Concrete;
import com.github.matjanko.calculators.api.materials.concrete.ConcreteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author matjanko
 *
 */

@Repository
public class ConcreteRepositoryImpl implements ConcreteRepository {

    @Override
    public List<Concrete> findAll() {
        return Materials.getConcretes();
    }

    @Override
    public Optional<Concrete> getOne(String name) {
        return Materials.getConcretes().stream()
                .filter(concrete -> concrete.getName().equals(name))
                .findAny();
    }
}
