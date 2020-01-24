package com.github.matjanko.calculators.api.materials.concrete;

import com.github.matjanko.calculators.api.materials.Material;

/**
 * @author matjanko
 *
 */

public interface Concrete extends Material {

    /**
     * Return the characteristic compressive cylinder strength of concrete
     * */
    int getFck();

    /**
     * Return the design compressive cylinder strength of concrete
     *
     * @param coefficientCC
     * The coefficient taking account of long term effects on the compressive strength
     * and of unfavourable effects resulting from the way the load is applied.
     * Recommended value is 1.0.
     *
     * @param safetyFactor
     * Safety factor for concrete for ultimate limit states depends on the country.
     * */
    double getFcd(double coefficientCC, double safetyFactor);

    /**
     * Return the characteristic compressive cube strength of concrete
     * */
    int getFckCube();

    /**
     * Return the mean compressive strength of concrete
     * */
    int getFcm();

    /**
     * Return the mean tensile strength of concrete
     * */
    double getFctm();

    /**
     * Return the five percent fractile tensile strength of concrete
     * */
    double getFctkFivePercent();

    /** Return the ninety five percent fractile tensile strength of concrete
     * */
    double getFctkNinetyFivePercent();

    /**
     * Return the design tensile strength of concrete
     *
     * @param coefficientCT
     * The coefficient taking account of long term effects on the tensile strength
     * and of unfavourable effects resulting from the way the load is applied.
     * Recommended value is 1.0.
     *
     * @param safetyFactor
     * Safety factor for concrete for ultimate limit states depends on the country.
     * */
    double getFctd(double coefficientCT, double safetyFactor);

    /**
     * Return the modulus of elasticity of concrete
     * */
    double getEcm();
}
