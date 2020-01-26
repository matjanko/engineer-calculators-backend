package com.github.matjanko.calculators.api.cover;

import org.springframework.stereotype.Service;

/**
 * @author matjanko
 *
 */

@Service
public interface MinimumCoverService {

    double getCoverByProtectionAgainstCorrosion(int barDiameter, int aggregateSize);

    double getCoverBySafeTransmissionOfBondForces(ExposureClass exposureClass, StructuralClass structuralClass);
}
