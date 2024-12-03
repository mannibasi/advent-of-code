package org.puzzles.rednosedreports;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testSafeReportWithAllLevelsDecreasing() {
        List<Integer> reportLevels = List.of(7, 6, 4, 2, 1);
        SafetyProcessor safetyProcessor = new SafetyProcessor(reportLevels);
        assertTrue(safetyProcessor.isSafe());
    }

    @Test
    public void testSafeReportWithAllLevelsIncreasing() {
        List<Integer> reportLevels = List.of(1, 3, 6, 7, 9);
        SafetyProcessor safetyProcessor = new SafetyProcessor(reportLevels);
        assertTrue(safetyProcessor.isSafe());
    }

    @Test
    public void testSafeReportWithValuesIncreasingAndDecreasingAffectedByDampener(){
        List<Integer> reportLevels = List.of(1, 3, 2, 4, 5);
        SafetyProcessor safetyProcessor = new SafetyProcessor(reportLevels);
        assertTrue(safetyProcessor.isSafe());
    }

    @Test
    public void testUnsafeReportWithValuesIncreasingAndDecreasingUnaffectedByDampener(){
        List<Integer> reportLevels = List.of(1, 3, 2, 4, 3);
        SafetyProcessor safetyProcessor = new SafetyProcessor(reportLevels);
        assertFalse(safetyProcessor.isSafe());
    }

    @Test
    public void testUnsafeReportWithValuesIncreasingByValueGreaterThanThree(){
        List<Integer> reportLevels = List.of(1, 2, 7, 8, 9);
        SafetyProcessor safetyProcessor = new SafetyProcessor(reportLevels);
        assertFalse(safetyProcessor.isSafe());
    }

    @Test
    public void testUnsafeReportWithValuesIncreasingByValueLessThanOne(){
        List<Integer> reportLevels = List.of(8, 6, 4, 4, 1);
        SafetyProcessor safetyProcessor = new SafetyProcessor(reportLevels);
        assertFalse(safetyProcessor.isSafe());
    }
}
