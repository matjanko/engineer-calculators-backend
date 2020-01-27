package com.github.matjanko.calculators.api.cover;

import com.github.matjanko.calculators.api.cover.impl.CoverDeviationServiceImpl;
import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * @author matjanko
 *
 */

@RunWith(JUnitParamsRunner.class)
public class CoverDeviationServiceTest {

    CoverDeviationService coverDeviationService;

    @Before
    public void initCoverDeviationService() {
        coverDeviationService = new CoverDeviationServiceImpl();
    }

    @Test
    public void getDeviationWithoutAnythingTest() {
        // given
        int actual = coverDeviationService.getDeviation(false, false);
        // then
        assertEquals(10, actual);
    }

    @Test
    public void getDeviationWhenQualityAssuranceSystemTest() {
        // given
        int actual = coverDeviationService.getDeviation(true, false);
        // then
        assertEquals(5, actual);
    }

    @Test
    public void getDeviationWhenAccurateMeasurementDeviceTest() {
        // given
        int actual = coverDeviationService.getDeviation(false, true);
        // then
        assertEquals(0, actual);
    }

    @Test
    public void getDeviationWhenQualityAssuranceSystemAndAccurateMeasurementDeviceTest() {
        // given
        int actual = coverDeviationService.getDeviation(true, true);
        // then
        assertEquals(0, actual);
    }
}
