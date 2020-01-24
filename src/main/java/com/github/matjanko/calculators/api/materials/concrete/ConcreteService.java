package com.github.matjanko.calculators.api.materials.concrete;

import com.github.matjanko.calculators.api.materials.base.exceptions.MaterialNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

/**
 * @author matjanko
 *
 */

@Service
public interface ConcreteService {

    Set<String> getClassesNames();

    List<ConcreteResponse> getAll();

    ConcreteResponse getByName(@NotBlank String className)
            throws MaterialNotFoundException;

}
