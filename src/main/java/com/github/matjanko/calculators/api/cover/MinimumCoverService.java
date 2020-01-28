package com.github.matjanko.calculators.api.cover;

import com.github.matjanko.calculators.api.exposure.ExposureClass;
import org.springframework.stereotype.Service;

/**
 * @author matjanko
 *
 */

@Service
public interface MinimumCoverService {

    int getCoverBySafeTransmissionOfBondForces(int barDiameter, int aggregateSize);

    int getCoverByProtectionAgainstCorrosion(ExposureClass exposureClass, StructuralClass structuralClass);

}
