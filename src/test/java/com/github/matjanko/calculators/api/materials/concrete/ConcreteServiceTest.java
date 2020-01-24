package com.github.matjanko.calculators.api.materials.concrete;

import com.github.matjanko.calculators.api.materials.concrete.impl.ConcreteRepositoryImpl;
import com.github.matjanko.calculators.api.materials.concrete.impl.ConcreteServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author matjanko
 *
 */

public class ConcreteServiceTest {

    private ConcreteRepository concreteRepository = new ConcreteRepositoryImpl();
    private ConcreteService concreteService;

    @Before
    public void initConcreteService() {
        concreteService = new ConcreteServiceImpl(concreteRepository);
    }

    @Test
    public void getClassesNamesTest() {
        // given
        Set<String> expected = new LinkedHashSet<>(Arrays.asList(
                "C12/15",
                "C16/20",
                "C20/25",
                "C25/30",
                "C30/37",
                "C35/45",
                "C40/50",
                "C45/55",
                "C50/60",
                "C55/67",
                "C60/75",
                "C70/85",
                "C80/95",
                "C90/105"));

        // when
        Set<String> actual = new LinkedHashSet<>(concreteService.getClassesNames());

        // then
        assertEquals(expected, actual);
    }
}
