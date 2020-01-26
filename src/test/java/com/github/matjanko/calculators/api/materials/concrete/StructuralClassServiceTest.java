package com.github.matjanko.calculators.api.materials.concrete;

import com.github.matjanko.calculators.api.cover.ExposureClass;
import com.github.matjanko.calculators.api.cover.StructuralClass;
import com.github.matjanko.calculators.api.cover.StructuralClassService;
import com.github.matjanko.calculators.api.cover.impl.StructuralClassServiceImpl;
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
public class StructuralClassServiceTest {

    StructuralClassService structuralClassService;

    @Before
    public void initStructuralClassService() {
        structuralClassService = new StructuralClassServiceImpl();
    }

    @Test
    public void shouldReturnS6WhenHundredYearsService() {
        // given
        StructuralClass actual =
                structuralClassService.getClass(ExposureClass.XC1, 25, true, false, false);
        // then
        assertEquals(StructuralClass.S6, actual);
    }

    @Test
    public void shouldReturnS3WhenSlabGeometry() {
        // given
        StructuralClass actual =
                structuralClassService.getClass(ExposureClass.XC1, 25, false, true, false);
        // then
        assertEquals(StructuralClass.S3, actual);
    }

    @Test
    public void shouldReturnS3WhenSpecialQualityControl() {
        // given
        StructuralClass actual =
                structuralClassService.getClass(ExposureClass.XC1, 25, false, false, true);
        // then
        assertEquals(StructuralClass.S3, actual);
    }

    @Test
    @Parameters({
            "30, XC0",
            "30, XC1",
            "35, XC2",
            "35, XC3",
            "40, XC4",
            "30, XF1",
            "35, XF2",
            "35, XF3",
            "40, XF4",
            "30, XA1",
            "35, XA2",
            "35, XA3",
            "40, XD1",
            "40, XD2",
            "45, XD3",
            "40, XS1",
            "45, XS2",
            "45, XS3"
    })
    public void shouldReturnS3WhenConcreteCompressiveStrengthAndExposureClass(int strength, ExposureClass exposureClass) {
        // given
        StructuralClass actual =
                structuralClassService.getClass(exposureClass, strength, false, false, false);
        // then
        assertEquals(StructuralClass.S3, actual);
    }

    @Test
    public void shouldReturnS2WhenSlabGeometryAndSpecialQualityControl() {
        // given
        StructuralClass actual =
                structuralClassService.getClass(ExposureClass.XC1, 25, false, true, true);
        // then
        assertEquals(StructuralClass.S2, actual);
    }

    @Test
    public void shouldReturnS4WhenSlabGeometryAndSpecialQualityControlAndHundredYearsService() {
        // given
        StructuralClass actual =
                structuralClassService.getClass(ExposureClass.XC1, 25, true, true, true);
        // then
        assertEquals(StructuralClass.S4, actual);
    }

    @Test
    @Parameters({
            "30, XC0",
            "30, XC1",
            "35, XC2",
            "35, XC3",
            "40, XC4",
            "30, XF1",
            "35, XF2",
            "35, XF3",
            "40, XF4",
            "30, XA1",
            "35, XA2",
            "35, XA3",
            "40, XD1",
            "40, XD2",
            "45, XD3",
            "40, XS1",
            "45, XS2",
            "45, XS3"
    })
    public void shouldReturnS1WhenConcreteCompressiveStrengthAndExposureClassAndSlabGeometryAndSpecialQualityControl(
            int strength, ExposureClass exposureClass) {
        // given
        StructuralClass actual =
                structuralClassService.getClass(exposureClass, strength, false, true, true);
        // then
        assertEquals(StructuralClass.S1, actual);
    }

    @Test
    @Parameters({
            "30, XC0",
            "30, XC1",
            "35, XC2",
            "35, XC3",
            "40, XC4",
            "30, XF1",
            "35, XF2",
            "35, XF3",
            "40, XF4",
            "30, XA1",
            "35, XA2",
            "35, XA3",
            "40, XD1",
            "40, XD2",
            "45, XD3",
            "40, XS1",
            "45, XS2",
            "45, XS3"
    })
    public void shouldReturnS3WhenConcreteCompressiveStrengthAndExposureClassAndSlabGeometryAndSpecialQualityControlAndHundredYearsService(
            int strength, ExposureClass exposureClass) {
        // given
        StructuralClass actual =
                structuralClassService.getClass(exposureClass, strength, true, true, true);
        // then
        assertEquals(StructuralClass.S3, actual);
    }

    @Test
    @Parameters({
            "25, XC0",
            "25, XC1",
            "30, XC2",
            "30, XC3",
            "35, XC4",
            "25, XF1",
            "30, XF2",
            "30, XF3",
            "35, XF4",
            "25, XA1",
            "30, XA2",
            "30, XA3",
            "35, XD1",
            "35, XD2",
            "40, XD3",
            "35, XS1",
            "40, XS2",
            "40, XS3"
    })
    public void shouldReturnS4WhenConcreteCompressiveStrengthAndExposureClass(int strength, ExposureClass exposureClass) {
        // given
        StructuralClass actual =
                structuralClassService.getClass(exposureClass, strength, false, false, false);
        // then
        assertEquals(StructuralClass.S4, actual);
    }

    @Test
    @Parameters({
            "25, XC0",
            "25, XC1",
            "30, XC2",
            "30, XC3",
            "35, XC4",
            "25, XF1",
            "30, XF2",
            "30, XF3",
            "35, XF4",
            "25, XA1",
            "30, XA2",
            "30, XA3",
            "35, XD1",
            "35, XD2",
            "40, XD3",
            "35, XS1",
            "40, XS2",
            "40, XS3"
    })
    public void shouldReturnS6WhenConcreteCompressiveStrengthAndExposureClassAndHundredYearsService(
            int strength, ExposureClass exposureClass) {
        // given
        StructuralClass actual =
                structuralClassService.getClass(exposureClass, strength, true, false, false);
        // then
        assertEquals(StructuralClass.S6, actual);
    }

    @Test
    @Parameters({
            "25, XC0",
            "25, XC1",
            "30, XC2",
            "30, XC3",
            "35, XC4",
            "25, XF1",
            "30, XF2",
            "30, XF3",
            "35, XF4",
            "25, XA1",
            "30, XA2",
            "30, XA3",
            "35, XD1",
            "35, XD2",
            "40, XD3",
            "35, XS1",
            "40, XS2",
            "40, XS3"
    })
    public void shouldReturnS3WhenConcreteCompressiveStrengthAndExposureClassAndSlabGeometry(
            int strength, ExposureClass exposureClass) {
        // given
        StructuralClass actual =
                structuralClassService.getClass(exposureClass, strength, false, true, false);
        // then
        assertEquals(StructuralClass.S3, actual);
    }

    @Test
    @Parameters({
            "25, XC0",
            "25, XC1",
            "30, XC2",
            "30, XC3",
            "35, XC4",
            "25, XF1",
            "30, XF2",
            "30, XF3",
            "35, XF4",
            "25, XA1",
            "30, XA2",
            "30, XA3",
            "35, XD1",
            "35, XD2",
            "40, XD3",
            "35, XS1",
            "40, XS2",
            "40, XS3"
    })
    public void shouldReturnS2WhenConcreteCompressiveStrengthAndExposureClassAndSlabGeometryAndSpecialQualityControl(
            int strength, ExposureClass exposureClass) {
        // given
        StructuralClass actual =
                structuralClassService.getClass(exposureClass, strength, false, true, true);
        // then
        assertEquals(StructuralClass.S2, actual);
    }

    @Test
    @Parameters({
            "25, XC0",
            "25, XC1",
            "30, XC2",
            "30, XC3",
            "35, XC4",
            "25, XF1",
            "30, XF2",
            "30, XF3",
            "35, XF4",
            "25, XA1",
            "30, XA2",
            "30, XA3",
            "35, XD1",
            "35, XD2",
            "40, XD3",
            "35, XS1",
            "40, XS2",
            "40, XS3"
    })
    public void shouldReturnS4WhenConcreteCompressiveStrengthAndExposureClassAndSlabGeometryAndSpecialQualityControlAndHundredYearsService(
            int strength, ExposureClass exposureClass) {
        // given
        StructuralClass actual =
                structuralClassService.getClass(exposureClass, strength, true, true, true);
        // then
        assertEquals(StructuralClass.S4, actual);
    }
}
