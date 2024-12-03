package org.puzzles.rednosedreports;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportTests {
    @Test
    public void testReportInputProcessing() {
        ReportReader reader = new ReportReader("src/test/resources/org/puzzles/rednosedreports/day_2_test_puzzle_input");
        List<String> reports = reader.readReports();
        assertAll(
                () -> assertEquals("40 42 44 47 49 50 48", reports.get(0)),
                () -> assertEquals("65 67 70 71 72 75 75", reports.get(1)),
                () -> assertEquals("74 76 78 81 83 85 87 91", reports.get(2))
        );
    }

    @Test
    public void testReportDataProcessing() {
        ReportProcessor processor = new ReportProcessor("40 42 44 47 49 50 48");
        List<Integer> levels = processor.readLevels();
        assertEquals(List.of(40, 42, 44, 47, 49, 50, 48), levels);
    }
}
