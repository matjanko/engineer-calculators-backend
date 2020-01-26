package com.github.matjanko.calculators.api.cover.impl;

import com.github.matjanko.calculators.api.cover.ExposureClass;
import com.github.matjanko.calculators.api.cover.StructuralClass;
import com.github.matjanko.calculators.api.cover.StructuralClassService;
import org.springframework.stereotype.Service;

/**
 * @author matjanko
 *
 */

@Service
public class StructuralClassServiceImpl implements StructuralClassService {
    @Override
    public StructuralClass getClass(ExposureClass exposureClass, int concreteCompressiveStrength,
                                    boolean isHundredYearsService, boolean isSlabGeometry,
                                    boolean isSpecialQualityControl) {
        return null;
    }
}
