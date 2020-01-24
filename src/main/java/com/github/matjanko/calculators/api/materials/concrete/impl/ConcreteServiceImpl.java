package com.github.matjanko.calculators.api.materials.concrete.impl;

import com.github.matjanko.calculators.api.materials.base.exceptions.MaterialNotFoundException;
import com.github.matjanko.calculators.api.materials.concrete.ConcreteRepository;
import com.github.matjanko.calculators.api.materials.concrete.ConcreteResponse;
import com.github.matjanko.calculators.api.materials.concrete.ConcreteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

/**
 * @author matjanko
 *
 */

@Service
@RequiredArgsConstructor
public class ConcreteServiceImpl implements ConcreteService {

    private final ConcreteRepository concreteRepository;

    @Override
    public Set<String> getClassesNames() {
        return null;
    }

    @Override
    public List<ConcreteResponse> getAll() {
        return null;
    }

    @Override
    public ConcreteResponse getByName(@NotBlank String className) throws MaterialNotFoundException {
        return null;
    }
}
