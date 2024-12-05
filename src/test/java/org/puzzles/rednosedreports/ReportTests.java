package org.puzzles.rednosedreports;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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
    public void testUnsafeReportWithValuesIncreasingByValueGreaterThanThreeUnaffectedByDampener(){
        List<Integer> reportLevels = List.of(1, 2, 7, 8, 9);
        SafetyProcessor safetyProcessor = new SafetyProcessor(reportLevels);
        assertFalse(safetyProcessor.isSafe());
    }

    @Test
    public void testSafeReportWithValuesIncreasingByValueLessThanOneAffectedByDampener(){
        List<Integer> reportLevels = List.of(8, 6, 4, 4, 1);
        SafetyProcessor safetyProcessor = new SafetyProcessor(reportLevels);
        assertTrue(safetyProcessor.isSafe());
    }

    @ParameterizedTest
    @MethodSource("provideReportLevels")
    public void testSafeEdgeCaseExamples(List<Integer> reportLevels) {
        SafetyProcessor safetyProcessor = new SafetyProcessor(reportLevels);
        assertTrue(safetyProcessor.isSafe());
    }

    static Stream<List<Integer>> provideReportLevels() {
        return Stream.of(
                List.of(48, 46, 47, 49, 51, 54, 56),
                List.of(1, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 5),
                List.of(5, 1, 2, 3, 4, 5),
                List.of(1, 4, 3, 2, 1),
                List.of(1, 6, 7, 8, 9),
                List.of(1, 2, 3, 4, 3),
                List.of(9, 8, 7, 6, 7),
                List.of(7, 10, 8, 10, 11),
                List.of(29, 28, 27, 25, 26, 22, 20),
                List.of(90, 89, 86, 84, 83, 79),
                List.of(97, 96, 93, 91, 85),
                List.of(29, 26, 24, 25, 21),
                List.of(36, 37, 40, 43, 47),
                List.of(43, 44, 47, 48, 49, 54),
                List.of(35, 33, 31, 29, 27, 25, 22, 18),
                List.of(77, 76, 73, 70, 64),
                List.of(68, 65, 69, 72, 74, 77, 80, 83),
                List.of(37, 40, 42, 43, 44, 47, 51),
                List.of(70, 73, 76, 79, 86)
        );
    }
}
