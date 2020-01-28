package com.github.matjanko.calculators.api.cover.impl;

import com.github.matjanko.calculators.api.exposure.ExposureClass;
import com.github.matjanko.calculators.api.cover.MinimumCoverService;
import com.github.matjanko.calculators.api.cover.StructuralClass;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.github.matjanko.calculators.api.exposure.ExposureClass.*;

/**
 * @author matjanko
 *
 */

@Service
public class MinimumCoverServiceImpl implements MinimumCoverService {

    private static final Map<List<ExposureClass>, Map<StructuralClass, Integer>> MINIMUM_COVER_MAP =
        getMinimumCoverMap();

    @Override
    public int getCoverBySafeTransmissionOfBondForces(int barDiameter, int aggregateSize) {
        return aggregateSize > 32 ? barDiameter + 5 : barDiameter;
    }

    @Override
    public int getCoverByProtectionAgainstCorrosion(ExposureClass exposureClass, StructuralClass structuralClass) {
        return MINIMUM_COVER_MAP.entrySet().stream()
                .filter(e -> e.getKey().stream().anyMatch(e1 -> e1 == exposureClass))
                .flatMap(st -> st.getValue().entrySet().stream())
                .filter(s -> s.getKey() == structuralClass)
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    private static Map<List<ExposureClass>, Map<StructuralClass, Integer>> getMinimumCoverMap() {

        Map<List<ExposureClass>, Map<StructuralClass, Integer>> minCoverMap = new HashMap<>();

        minCoverMap.put(Collections.singletonList(XC0),
                getStructuralClassCoversMap(Arrays.asList(10, 10, 10, 10, 15, 20)));
        minCoverMap.put(Arrays.asList(XC1, XF1, XA1),
                getStructuralClassCoversMap(Arrays.asList(10, 10, 10, 15, 20, 25)));
        minCoverMap.put(Arrays.asList(XC2, XF2, XA2, XC3, XF3, XA3),
                getStructuralClassCoversMap(Arrays.asList(10, 15, 20, 25, 30, 35)));
        minCoverMap.put(Arrays.asList(XC4, XF4),
                getStructuralClassCoversMap(Arrays.asList(15, 20, 25, 30, 35, 40)));
        minCoverMap.put(Arrays.asList(XD1, XS1),
                getStructuralClassCoversMap(Arrays.asList(20, 25, 30, 35, 40, 45)));
        minCoverMap.put(Arrays.asList(XD2, XS2),
                getStructuralClassCoversMap(Arrays.asList(25, 30, 35, 40, 45, 55)));
        minCoverMap.put(Arrays.asList(XD3, XS3),
                getStructuralClassCoversMap(Arrays.asList(30, 35, 40, 45, 50, 55)));

        return minCoverMap;
    }

    private static Map<StructuralClass, Integer> getStructuralClassCoversMap(List<Integer> covers) {
        Map<StructuralClass, Integer> coverMap = new LinkedHashMap<>();
        int counter = 1;
        for(Integer cover : covers) {
            coverMap.put(StructuralClass.valueOf("S" + counter), cover);
            ++counter;
        }
        return coverMap;
    }
}
