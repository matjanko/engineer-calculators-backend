package com.github.matjanko.calculators.api.materials.concrete;

import lombok.Getter;

/**
 * @author matjanko
 *
 */

@Getter
public enum ConcreteClass {
    C12_15("C12/15"),
    C16_20("C16/20"),
    C20_25("C20/25"),
    C25_30("C25/30"),
    C30_37("C30/37"),
    C35_45("C35/45"),
    C40_50("C40/50"),
    C45_55("C45/55"),
    C50_60("C50/60"),
    C55_67("C55/67"),
    C60_75("C60/75"),
    C70_85("C70/85"),
    C80_95("C80/95"),
    C90_105("C90/105");

    private String name;

    ConcreteClass(String name) {
        this.name = name;
    }

    public int getFck() {
        return Integer.parseInt(splitName()[1]);
    }

    public int getFckCube() {
        return Integer.parseInt(splitName()[2]);
    }

    private String[] splitName() {
        return name.split("[C/]");
    }
}
