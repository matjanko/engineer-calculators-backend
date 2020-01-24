package com.github.matjanko.calculators.api.materials.concrete.impl;

import com.github.matjanko.calculators.api.materials.concrete.Concrete;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Size;

/**
 * @author matjanko
 *
 */

@RequiredArgsConstructor
@EqualsAndHashCode
public class ConcreteImpl implements Concrete {

    @Size(max = 3)
    private final int fck;
    @Size(max = 3)
    private final int fckCube;


    @Override
    public int getFck() {
        return 0;
    }

    @Override
    public double getFcd(double coefficientCC, double safetyFactor) {
        return 0;
    }

    @Override
    public int getFckCube() {
        return 0;
    }

    @Override
    public int getFcm() {
        return 0;
    }

    @Override
    public double getFctm() {
        return 0;
    }

    @Override
    public double getFctkFivePercent() {
        return 0;
    }

    @Override
    public double getFctkNinetyFivePercent() {
        return 0;
    }

    @Override
    public double getFctd(double coefficientCT, double safetyFactor) {
        return 0;
    }

    @Override
    public double getEcm() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}
