package com.github.matjanko.calculators.api.cover.impl;

import com.github.matjanko.calculators.api.exposure.ExposureClass;
import com.github.matjanko.calculators.api.cover.StructuralClass;
import com.github.matjanko.calculators.api.cover.StructuralClassService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.github.matjanko.calculators.api.exposure.ExposureClass.*;

/**
 * @author matjanko
 *
 */

@Service
public class StructuralClassServiceImpl implements StructuralClassService {

    private static final Map<ExposureClass, Integer> EXPOSURE_COMPRESSIVE
            = getExposureClassCompressiveStrengthMap();

    @Override
    public StructuralClass getClass(ExposureClass exposureClass, int concreteCompressiveStrength,
                                    boolean isHundredYearsService, boolean isSlabGeometry,
                                    boolean isSpecialQualityControl) {
        int classCounter = 4;

        classCounter = getCountForHundredYearsServiceCondition(classCounter, isHundredYearsService);

        classCounter = getCountForSlabGeometryCondition(classCounter, isSlabGeometry);

        classCounter = getCountForSpecialQualityControlCondition(classCounter, isSpecialQualityControl);

        classCounter = getCountForExposureAndConcreteCondition(
                classCounter, exposureClass, concreteCompressiveStrength);

        String className = "S" + classCounter;

        return StructuralClass.valueOf(className);
    }

    private int getCountForHundredYearsServiceCondition(int counter, boolean isService) {
        return isService ? counter + 2 : counter;
    }

    private int getCountForSlabGeometryCondition(int counter, boolean isSlab) {
        return isSlab ? counter - 1 : counter;
    }

    private int getCountForSpecialQualityControlCondition(int counter, boolean isSpecialQuality) {
        return isSpecialQuality ? counter - 1 : counter;
    }

    private int getCountForExposureAndConcreteCondition(int counter, ExposureClass exposureClass,
                                                        int concreteCompressiveStrength) {

        int requiredCompressiveStrength = EXPOSURE_COMPRESSIVE.entrySet().stream()
                .filter(exp -> exp.getKey() == exposureClass)
                .map(Map.Entry::getValue)
                .findAny().orElse(0);

        if (concreteCompressiveStrength >= requiredCompressiveStrength) {
            return counter - 1;
        }

        return counter;
    }

    private static Map<ExposureClass, Integer> getExposureClassCompressiveStrengthMap() {
        Map<ExposureClass, Integer> map = new HashMap<>();

        map.put(XC0, 30);
        map.put(XC1, 30);
        map.put(XC2, 35);
        map.put(XC3, 35);
        map.put(XC4, 40);

        map.put(XD1, 40);
        map.put(XD2, 40);
        map.put(XD3, 45);

        map.put(XS1, 40);
        map.put(XS2, 45);
        map.put(XS3, 45);

        map.put(XF1, 30);
        map.put(XF2, 35);
        map.put(XF3, 35);
        map.put(XF4, 40);

        map.put(XA1, 30);
        map.put(XA2, 35);
        map.put(XA3, 35);

        return map;
    }
}
