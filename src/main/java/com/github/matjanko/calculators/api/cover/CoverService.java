package com.github.matjanko.calculators.api.cover;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author matjanko
 *
 */

@Service
public interface CoverService {

    CoverResponse getCalculation(@NotNull CoverRequest coverRequest);

}
