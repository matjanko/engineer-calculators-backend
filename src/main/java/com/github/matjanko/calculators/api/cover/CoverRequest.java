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

    @NotBlank(message = "No concrete class given")
    private String concreteClass;
    @NotNull(message = "No aggregate size given")
    private Integer aggregateSize;
    @NotNull(message = "No bar diameter given")
    private Integer barDiameter;
    @NotBlank(message = "No exposure class given")
    private String exposureClass;

    private boolean isHundredYearsService;
    private boolean isSlabGeometry;
    private boolean isSpecialQualityControl;
    private boolean isQualityAssuranceSystem;
    private boolean isAccurateMeasurementDevice;

    private Integer deviation;
}
