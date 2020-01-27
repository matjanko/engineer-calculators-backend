package com.github.matjanko.calculators.api.cover.impl;

import com.github.matjanko.calculators.api.cover.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author matjanko
 *
 */

@Service
@RequiredArgsConstructor
public class CoverServiceImpl implements CoverService {

    private final StructuralClassService structuralClassService;
    private final MinimumCoverService minimumCoverService;
    private final CoverDeviationService coverDeviationService;

    @Override
    public CoverResponse getCalculation(@NotNull CoverRequest coverRequest) {
        ExposureClass exposureClass = ExposureClass.valueOf(coverRequest.getExposureClass());
        StructuralClass structuralClass = getStructuralClass(exposureClass, coverRequest);
        int bondMinCover = getBondMinCover(coverRequest);
        int environmentalMinCover = getEnvironmentalMinCover(exposureClass, structuralClass);
        int minCover = getMinCover(bondMinCover, environmentalMinCover);
        int deviation = getDeviation(coverRequest);
        int nomCover = minCover + deviation;

        CoverResponse resp = new CoverResponse();
        resp.setCoverRequest(coverRequest);
        resp.setStructuralClass(structuralClass.name());
        resp.setMinCover(minCover);
        resp.setDeviation(deviation);
        resp.setNominalCover(nomCover);
        resp.setEnvironmentalConditionsMinCover(environmentalMinCover);
        resp.setBondMinCover(bondMinCover);
        return resp;
    }

    private StructuralClass getStructuralClass(ExposureClass exp, CoverRequest req) {
        return structuralClassService.getClass(exp, getConcreteCompressiveStrength(req),
                req.isHundredYearsService(), req.isSlabGeometry(), req.isSpecialQualityControl());
    }

    private int getConcreteCompressiveStrength(CoverRequest req) {
        String[] arr = req.getConcreteClass().split("[C/]+");
        return Integer.parseInt(arr[0]);
    }

    private int getBondMinCover(CoverRequest req) {
        return minimumCoverService.getCoverBySafeTransmissionOfBondForces(
                req.getBarDiameter(), req.getAggregateSize());
    }

    private int getEnvironmentalMinCover(ExposureClass exp, StructuralClass sc) {
        return minimumCoverService.getCoverByProtectionAgainstCorrosion(exp, sc);
    }

    private int getMinCover(int bondMinCover, int environmentalMinCover) {
        return Math.max(bondMinCover, environmentalMinCover);
    }

    private int getDeviation(CoverRequest req) {
        if (req.getDeviation() != null) {
            return req.getDeviation();
        } else {
            return coverDeviationService.getDeviation(
                    req.isQualityAssuranceSystem(), req.isAccurateMeasurementDevice());
        }
    }
}
