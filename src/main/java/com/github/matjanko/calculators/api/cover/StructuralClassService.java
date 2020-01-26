package com.github.matjanko.calculators.api.cover;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;

/**
 * @author matjanko
 *
 */

@Service
public interface StructuralClassService {

    StructuralClass getClass(@NotBlank String exposureClass, int concreteCompressiveStrength,
                             boolean isHundredYearsService, boolean isSlabGeometry,
                             boolean isSpecialQualityControl);
}
