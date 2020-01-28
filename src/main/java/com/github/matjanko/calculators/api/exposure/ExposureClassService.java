package com.github.matjanko.calculators.api.exposure;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author matjanko
 *
 */

@Service
public interface ExposureClassService {

    List<String> getAllExposureClasses();

}
