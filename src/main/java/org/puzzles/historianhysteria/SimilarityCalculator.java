package org.puzzles.historianhysteria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimilarityCalculator {
    private final List<Integer> locationIdListOne;
    private final Map<Integer, Integer> locationIdListTwoOccurrencesMap;

    public SimilarityCalculator(List<Integer> locationIdListOne, List<Integer> locationIdListTwo) {
        this.locationIdListOne = locationIdListOne;
        this.locationIdListTwoOccurrencesMap = buildOccurrencesMap(locationIdListTwo);
    }

    public int calculate() {
        return locationIdListOne.stream()
                .filter(locationIdListTwoOccurrencesMap::containsKey)
                .mapToInt(id -> id * locationIdListTwoOccurrencesMap.get(id))
                .sum();
    }

    private Map<Integer, Integer> buildOccurrencesMap(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer id : list) {
            map.put(id, map.getOrDefault(id, 0) + 1);
        }
        return map;
    }
}