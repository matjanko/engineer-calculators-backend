package com.github.matjanko.calculators.api.materials.concrete;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

/**
 * @author matjanko
 *
 */

@Getter
@Setter(AccessLevel.PUBLIC)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ConcreteResponse extends RepresentationModel<ConcreteResponse> {

    @EqualsAndHashCode.Include
    private String name;

    private int fck;
    private int fckCube;
    private int fcm;
    private double fctm;
    private double fctk5;
    private double fctk95;
    private double ecm;
    private double weight;

}
