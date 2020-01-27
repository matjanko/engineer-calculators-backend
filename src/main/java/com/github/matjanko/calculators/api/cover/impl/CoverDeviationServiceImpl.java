package com.github.matjanko.calculators.api.cover.impl;

import com.github.matjanko.calculators.api.cover.CoverDeviationService;
import org.springframework.stereotype.Service;

/**
 * @author matjanko
 *
 */

@Service
public class CoverDeviationServiceImpl implements CoverDeviationService {

    @Override
    public int getDeviation(boolean isQualityAssuranceSystem, boolean isAccurateMeasurementDevice) {
        if (isAccurateMeasurementDevice) {
            return 0;
        } else if (isQualityAssuranceSystem) {
            return 5;
        } else {
            return 10;
        }
    }
}
