package org.puzzles.printqueue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaperSorterTests {
    @Test
    public void testExamplePageOrdering() {
        Integer[][] sortingRules = {{47, 53},{97, 13}, {97, 61}};
        PageSorter pageSorter = new PageSorter(sortingRules);
        LinkedList<Integer> pagesUpdates = new LinkedList<>();
        pagesUpdates.add(75);
        pagesUpdates.add(47);
        pagesUpdates.add(61);
        pagesUpdates.add(53);
        pagesUpdates.add(29);

        List<Integer> sortedPages = pageSorter.sortPages(pagesUpdates);
        assertEquals(sortedPages, new ArrayList<>(Arrays.asList(75, 47, 61, 53, 29)));
    }
}
