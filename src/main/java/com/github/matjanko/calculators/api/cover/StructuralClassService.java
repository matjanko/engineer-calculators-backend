package com.github.matjanko.calculators.api.cover;

import org.springframework.stereotype.Service;

/**
 * @author matjanko
 *
 */

@Service
public interface StructuralClassService {

    StructuralClass getClass(ExposureClass exposureClass, int concreteCompressiveStrength,
                             boolean isHundredYearsService, boolean isSlabGeometry,
                             boolean isSpecialQualityControl);
}
