package com.github.matjanko.calculators.api.cover;

import org.springframework.stereotype.Service;

/**
 * @author matjanko
 *
 */

@Service
public interface MinimumCoverService {

    double getCoverBySafeTransmissionOfBondForces(int barDiameter, int aggregateSize);

    double getCoverByProtectionAgainstCorrosion(ExposureClass exposureClass, StructuralClass structuralClass);

}
