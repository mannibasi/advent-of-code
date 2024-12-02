package org.puzzles;

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
        int similarityScore = 0;
        for (Integer id : locationIdListOne) {
            if (locationIdListTwoOccurrencesMap.containsKey(id)) {
                similarityScore += id * locationIdListTwoOccurrencesMap.get(id);
            }
        }
        return similarityScore;
    }

    private Map<Integer, Integer> buildOccurrencesMap(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer id : list) {
            map.put(id, map.getOrDefault(id, 0) + 1);
        }
        return map;
    }
}