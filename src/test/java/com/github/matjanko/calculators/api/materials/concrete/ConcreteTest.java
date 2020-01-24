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
            "12, 15, C12/15",
            "30, 37, C30/37",
            "90, 105, C90/105"
    })
    public void getClassNameTest(int fck, int fckCube, String expected) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(expected, concrete.getName());
    }

    @Test
    @Parameters({
            "12, 15, 12",
            "30, 37, 30",
            "90, 105, 90"
    })
    public void getFckTest(int fck, int fckCube, int expected) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(expected, concrete.getFck());
    }

    @Test
    @Parameters({
            "12, 15, 15",
            "30, 37, 37",
            "90, 105, 105"
    })
    public void getFckCubeTest(int fck, int fckCube, int expected) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(expected, concrete.getFckCube());
    }

    @Test
    @Parameters({
            "12, 15, 20",
            "30, 37, 38",
            "90, 105, 98"
    })
    public void getFcmTest(int fck, int fckCube, int expected) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(expected, concrete.getFcm());
    }

    @Test
    @Parameters({
            "12, 15, 1.6",
            "16, 20, 1.9",
            "20, 25, 2.2",
            "50, 60, 4.1",
            "55, 67, 4.2",
            "90, 105, 5.0"
    })
    public void getFctmTest(int fck, int fckCube, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(expected, concrete.getFctm(), 0);
    }

    @Test
    @Parameters({
            "12, 15, 1.1",
            "16, 20, 1.3",
            "20, 25, 1.5",
            "50, 60, 2.9",
            "55, 67, 3.0",
            "90, 105, 3.5"
    })
    public void getFctkFivePercentTest(int fck, int fckCube, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(expected, concrete.getFctkFivePercent(), 0);
    }

    @Test
    @Parameters({
            "12, 15, 2.0",
            "16, 20, 2.5",
            "20, 25, 2.9",
            "50, 60, 5.3",
            "55, 67, 5.5",
            "90, 105, 6.6"
    })
    public void getFctkNinetyFivePercentTest(int fck, int fckCube, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(expected, concrete.getFctkNinetyFivePercent(), 0);
    }

    @Test
    @Parameters({
            "12, 15, 27",
            "16, 20, 29",
            "20, 25, 30",
            "50, 60, 37",
            "55, 67, 38",
            "90, 105, 44"
    })
    public void getEcmTest(int fck, int fckCube, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(expected, concrete.getEcm(), 0);
    }

    @Test
    @Parameters({
            "12, 15, 1.0, 1.5, 8.00",
            "30, 37, 0.82, 1.4, 17.57"
    })
    public void getFcdTest(int fck, int fckCube, double coefficient,  double safetyFactor, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(expected, concrete.getFcd(coefficient, safetyFactor), 0);
    }

    @Test
    @Parameters({
            "12, 15, 1.0, 1.5, 0.73",
            "35, 45, 0.82, 1.4, 1.29"
    })
    public void getFctdTest(int fck, int fckCube, double coefficient,  double safetyFactor, double expected) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(expected, concrete.getFctd(coefficient, safetyFactor), 0);
    }

    @Test
    @Parameters({
            "12, 15",
            "35, 45"
    })
    public void getWeightTest(int fck, int fckCube) {
        // given
        Concrete concrete = new ConcreteImpl(fck, fckCube);
        // then
        assertEquals(2500, concrete.getWeight(), 0);
    }
}
