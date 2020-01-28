package com.github.matjanko.calculators.api.cover;

import com.github.matjanko.calculators.api.exposure.ExposureClass;
import com.github.matjanko.calculators.api.materials.concrete.ConcreteClass;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author matjanko
 *
 */

@Getter @Setter
public class CoverRequest {

    @NotNull(message = "No concrete class given")
    private ConcreteClass concreteClass;
    @NotNull(message = "No aggregate size given")
    private Integer aggregateSize;
    @NotNull(message = "No bar diameter given")
    private Integer barDiameter;
    @NotNull(message = "No exposure class given")
    private ExposureClass exposureClass;

    private boolean isHundredYearsService;
    private boolean isSlabGeometry;
    private boolean isSpecialQualityControl;
    private boolean isQualityAssuranceSystem;
    private boolean isAccurateMeasurementDevice;

    private Integer deviation;
}
