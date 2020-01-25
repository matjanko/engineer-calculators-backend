package com.github.matjanko.calculators.api.cover;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author matjanko
 *
 */

@Getter @Setter
public class CoverRequest {

    @NotBlank
    private String concreteClass;
    @NotBlank
    private Integer aggregateSize;
    @NotNull
    private Integer barDiameter;
    @NotBlank
    private String exposureClass;

    private boolean isHundredYearsService;
    private boolean isSlabGeometry;
    private boolean isSpecialQualityControl;
    private boolean isQualityAssuranceSystem;
    private boolean isAccurateMeasurementDevice;

    private Integer deviation;
}
