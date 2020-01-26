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
public class CoverResponse {

    @NotNull
    private CoverRequest coverRequest;
    @NotBlank
    private String structuralClass;

    private int bondMinCover;
    private int environmentalConditionsMinCover;
    private int minCover;
    private int nominalCover;
    private int deviation;
}
