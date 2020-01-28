package com.github.matjanko.calculators.api.materials.concrete;

import com.github.matjanko.calculators.api.materials.concrete.impl.ConcreteImpl;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * @author matjanko
 *
 */

@RunWith(JUnitParamsRunner.class)
public class ConcreteTest {

    @Test
    @Parameters({
            "C12_15, C12/15",
            "C30_37, C30/37",
            "C90_105, C90/105"
    })
    public void getNameTest(ConcreteClass concreteClass, String expected) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(expected, concrete.getName());
    }

    @Test
    @Parameters({
            "C12_15, 12",
            "C30_37, 30",
            "C90_105, 90"
    })
    public void getFckTest(ConcreteClass concreteClass, int expected) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(expected, concrete.getFck());
    }

    @Test
    @Parameters({
            "C12_15, 15",
            "C30_37, 37",
            "C90_105, 105"
    })
    public void getFckCubeTest(ConcreteClass concreteClass, int expected) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(expected, concrete.getFckCube());
    }

    @Test
    @Parameters({
            "C12_15, 20",
            "C30_37, 38",
            "C90_105, 98"
    })
    public void getFcmTest(ConcreteClass concreteClass, int expected) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(expected, concrete.getFcm());
    }

    @Test
    @Parameters({
            "C12_15, 1.6",
            "C16_20, 1.9",
            "C20_25, 2.2",
            "C50_60, 4.1",
            "C55_67, 4.2",
            "C90_105, 5.0"
    })
    public void getFctmTest(ConcreteClass concreteClass, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(expected, concrete.getFctm(), 0);
    }

    @Test
    @Parameters({
            "C12_15, 1.1",
            "C16_20, 1.3",
            "C20_25, 1.5",
            "C50_60, 2.9",
            "C55_67, 3.0",
            "C90_105, 3.5"
    })
    public void getFctkFivePercentTest(ConcreteClass concreteClass, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(expected, concrete.getFctkFivePercent(), 0);
    }

    @Test
    @Parameters({
            "C12_15, 2.0",
            "C16_20, 2.5",
            "C20_25, 2.9",
            "C50_60, 5.3",
            "C55_67, 5.5",
            "C90_105, 6.6"
    })
    public void getFctkNinetyFivePercentTest(ConcreteClass concreteClass, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(expected, concrete.getFctkNinetyFivePercent(), 0);
    }

    @Test
    @Parameters({
            "C12_15, 27",
            "C16_20, 29",
            "C20_25, 30",
            "C50_60, 37",
            "C55_67, 38",
            "C90_105, 44"
    })
    public void getEcmTest(ConcreteClass concreteClass, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(expected, concrete.getEcm(), 0);
    }

    @Test
    @Parameters({
            "C12_15, 1.0, 1.5, 8.00",
            "C30_37, 0.82, 1.4, 17.57"
    })
    public void getFcdTest(ConcreteClass concreteClass, double coefficient,  double safetyFactor, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(expected, concrete.getFcd(coefficient, safetyFactor), 0);
    }

    @Test
    @Parameters({
            "C12_15, 1.0, 1.5, 0.73",
            "C35_45, 0.82, 1.4, 1.29"
    })
    public void getFctdTest(ConcreteClass concreteClass, double coefficient,  double safetyFactor, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(expected, concrete.getFctd(coefficient, safetyFactor), 0);
    }

    @Test
    @Parameters({
            "C12_15",
            "C35_45"
    })
    public void getWeightTest(ConcreteClass concreteClass) {
        // given
        Concrete concrete = new ConcreteImpl(concreteClass);
        // then
        assertEquals(2500, concrete.getWeight(), 0);
    }
}
