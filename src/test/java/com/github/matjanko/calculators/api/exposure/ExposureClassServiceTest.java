package com.github.matjanko.calculators.api.exposure;

import com.github.matjanko.calculators.api.exposure.impl.ExposureClassServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author matjanko
 *
 */

public class ExposureClassServiceTest {

    ExposureClassService exposureClassService;

    @Before
    public void initExposureClassService() {
        exposureClassService = new ExposureClassServiceImpl();
    }

    @Test
    public void getAllExposureClassesTest() {
        // given
        List<String> expectedList = Arrays.asList(
                "XC0", "XC1", "XC2", "XC3", "XC4", "XD1", "XD2", "XD3", "XS1",
                "XS2", "XS3", "XF1", "XF2", "XF3", "XF4", "XA1", "XA2", "XA3");

        // when
        List<String> actualList = exposureClassService.getAllExposureClasses();

        // then
        Assert.assertEquals(expectedList, actualList);
    }
}
