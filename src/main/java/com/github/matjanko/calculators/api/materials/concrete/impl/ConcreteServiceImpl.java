package com.github.matjanko.calculators.api.materials.concrete.impl;

import com.github.matjanko.calculators.api.materials.base.exceptions.MaterialNotFoundException;
import com.github.matjanko.calculators.api.materials.concrete.Concrete;
import com.github.matjanko.calculators.api.materials.concrete.ConcreteRepository;
import com.github.matjanko.calculators.api.materials.concrete.ConcreteResponse;
import com.github.matjanko.calculators.api.materials.concrete.ConcreteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
        return concreteRepository.findAll().stream()
                .map(Concrete::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public List<ConcreteResponse> getAll() {
        return concreteRepository.findAll().stream()
                .map(this::mapFrom)
                .collect(Collectors.toList());
    }

    @Override
    public ConcreteResponse getByName(@NotBlank String className) throws MaterialNotFoundException {
        Optional<Concrete> concrete = concreteRepository.getOne(className);

        if (concrete.isPresent()) {
            return this.mapFrom(concrete.get());
        }

        throw new MaterialNotFoundException("Concrete " + className +" not found");
    }

    private ConcreteResponse mapFrom (Concrete concrete) {
        ConcreteResponse response = new ConcreteResponse();

        response.setName(concrete.getName());
        response.setFck(concrete.getFck());
        response.setFckCube(concrete.getFckCube());
        response.setFcm(concrete.getFcm());
        response.setFctm(concrete.getFctm());
        response.setFctk5(concrete.getFctkFivePercent());
        response.setFctk95(concrete.getFctkNinetyFivePercent());
        response.setEcm(concrete.getEcm());
        response.setWeight(concrete.getWeight());

        return response;
    }
}
