package com.github.matjanko.calculators.api.exposure.impl;

import com.github.matjanko.calculators.api.exposure.ExposureClass;
import com.github.matjanko.calculators.api.exposure.ExposureClassService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author matjanko
 *
 */

@Service
public class ExposureClassServiceImpl implements ExposureClassService {

    @Override
    public List<String> getAllExposureClasses() {
        return Stream.of(ExposureClass.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
