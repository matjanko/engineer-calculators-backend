package com.github.matjanko.calculators.api.materials.concrete;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author matjanko
 *
 */

@Repository
public interface ConcreteRepository {

    List<Concrete> findAll();

    Optional<Concrete> getOne(String name);
}
