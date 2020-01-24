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
        return fck;
    }

    @Override
    public double getFcd(double coefficientCC, double safetyFactor) {
        return Math.round((coefficientCC * fck) / safetyFactor * 100) / 100D;
    }

    @Override
    public int getFckCube() {
        return fckCube;
    }

    @Override
    public int getFcm() {
        return fck + 8;
    }

    @Override
    public double getFctm() {
        return Math.round(this.calculateFctm() * 10) / 10D;
    }

    @Override
    public double getFctkFivePercent() {
        return Math.round(0.7 * this.calculateFctm() * 10) / 10D;
    }

    @Override
    public double getFctkNinetyFivePercent() {
        return Math.round(1.3 * this.calculateFctm() * 10) / 10D;
    }

    @Override
    public double getFctd(double coefficientCT, double safetyFactor) {
        return Math.round((coefficientCT * getFctkFivePercent()) / safetyFactor * 100) / 100D;
    }

    @Override
    public double getEcm() {
        return Math.round(22 * Math.pow((getFcm() / 10f),0.3)) / 1D;
    }

    @Override
    public String getName() {
        return "C" +
                fck +
                "/" +
                fckCube;
    }

    @Override
    public double getWeight() {
        return 2500L;
    }

    private double calculateFctm() {
        if (fck <= 50) {
            return 0.3 * Math.pow(fck, 2 / 3f);
        } else {
            return 2.12 * Math.log(1 + (getFcm() / 10f));
        }
    }
}
