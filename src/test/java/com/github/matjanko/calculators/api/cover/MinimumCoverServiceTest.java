package com.github.matjanko.calculators.api.cover;

import com.github.matjanko.calculators.api.cover.ExposureClass;
import com.github.matjanko.calculators.api.cover.MinimumCoverService;
import com.github.matjanko.calculators.api.cover.StructuralClass;
import com.github.matjanko.calculators.api.cover.impl.MinimumCoverServiceImpl;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * @author matjanko
 *
 */

@RunWith(JUnitParamsRunner.class)
public class MinimumCoverServiceTest {

    MinimumCoverService minimumCoverService;

    @Before
    public void initMinimumCoverService() {
        minimumCoverService = new MinimumCoverServiceImpl();
    }

    @Test
    @Parameters ({
            "8, 32, 8",
            "16, 32, 16",
            "32, 40, 37"
    })
    public void getCoverBySafeTransmissionOfBondForcesTest(int barDiameter, int aggregateSize, int expected) {
        // when
        int actual = minimumCoverService.getCoverBySafeTransmissionOfBondForces(barDiameter, aggregateSize);
        // then
        assertEquals(expected, actual);
    }

    @Test
    @Parameters ({
            "S1, XC0, 10", "S2, XC0, 10", "S3, XC0, 10", "S4, XC0, 10", "S5, XC0, 15", "S6, XC0, 20",
            "S1, XC1, 10", "S2, XC1, 10", "S3, XC1, 10", "S4, XC1, 15", "S5, XC1, 20", "S6, XC1, 25",
            "S1, XA1, 10", "S2, XA1, 10", "S3, XA1, 10", "S4, XA1, 15", "S5, XA1, 20", "S6, XA1, 25",
            "S1, XF1, 10", "S2, XF1, 10", "S3, XF1, 10", "S4, XF1, 15", "S5, XF1, 20", "S6, XF1, 25",
            "S1, XC2, 10", "S2, XC2, 15", "S3, XC2, 20", "S4, XC2, 25", "S5, XC2, 30", "S6, XC2, 35",
            "S1, XA2, 10", "S2, XA2, 15", "S3, XA2, 20", "S4, XA2, 25", "S5, XA2, 30", "S6, XA2, 35",
            "S1, XF2, 10", "S2, XF2, 15", "S3, XF2, 20", "S4, XF2, 25", "S5, XF2, 30", "S6, XF2, 35",
            "S1, XC3, 10", "S2, XC3, 15", "S3, XC3, 20", "S4, XC3, 25", "S5, XC3, 30", "S6, XC3, 35",
            "S1, XA3, 10", "S2, XA3, 15", "S3, XA3, 20", "S4, XA3, 25", "S5, XA3, 30", "S6, XA3, 35",
            "S1, XF3, 10", "S2, XF3, 15", "S3, XF3, 20", "S4, XF3, 25", "S5, XF3, 30", "S6, XF3, 35",
            "S1, XC4, 15", "S2, XC4, 20", "S3, XC4, 25", "S4, XC4, 30", "S5, XC4, 35", "S6, XC4, 40",
            "S1, XF4, 15", "S2, XF4, 20", "S3, XF4, 25", "S4, XF4, 30", "S5, XF4, 35", "S6, XF4, 40",
            "S1, XD1, 20", "S2, XD1, 25", "S3, XD1, 30", "S4, XD1, 35", "S5, XD1, 40", "S6, XD1, 45",
            "S1, XS1, 20", "S2, XS1, 25", "S3, XS1, 30", "S4, XS1, 35", "S5, XS1, 40", "S6, XS1, 45",
            "S1, XD2, 25", "S2, XD2, 30", "S3, XD2, 35", "S4, XD2, 40", "S5, XD2, 45", "S6, XD2, 55",
            "S1, XS2, 25", "S2, XS2, 30", "S3, XS2, 35", "S4, XS2, 40", "S5, XS2, 45", "S6, XS2, 55",
            "S1, XD3, 30", "S2, XD3, 35", "S3, XD3, 40", "S4, XD3, 45", "S5, XD3, 50", "S6, XD3, 55",
            "S1, XS3, 30", "S2, XS3, 35", "S3, XS3, 40", "S4, XS3, 45", "S5, XS3, 50", "S6, XS3, 55",

    })
    public void getCoverByProtectionAgainstCorrosionTest(StructuralClass structuralClass,
                                                         ExposureClass exposureClass,
                                                         int expected) {
        // when
        int actual = minimumCoverService.getCoverByProtectionAgainstCorrosion(exposureClass, structuralClass);
        // then
        assertEquals(expected, actual);
    }
}
