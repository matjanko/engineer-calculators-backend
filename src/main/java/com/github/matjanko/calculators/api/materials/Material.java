package com.github.matjanko.calculators.api.materials;

/**
 * @author matjanko
 *
 */

public interface Material {

    /**
     * Return the specified class name depending on the type of material
     * */
    String getName();

    /**
     * Return the weight of material on Earth
     * */
    double getWeight();
}
