package com.github.matjanko.calculators.api.cover;

import org.springframework.stereotype.Service;

/**
 * @author matjanko
 *
 */

@Service
public interface CoverDeviationService {

    int getDeviation(boolean isQualityAssuranceSystem, boolean isAccurateMeasurementDevice);

}
