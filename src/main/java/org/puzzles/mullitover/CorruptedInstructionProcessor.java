package org.puzzles.mullitover;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorruptedInstructionProcessor {
    private final String corruptedInstructions;

    public CorruptedInstructionProcessor(String corruptedInstructions) {
        this.corruptedInstructions = corruptedInstructions;
    }

    public List<String> getMultiplicationInstructions() {
        List<String> matches = new ArrayList<>();
        Matcher matcher = Pattern.compile("mul\\(\\d+,\\d+\\)").matcher(corruptedInstructions);
        int lastEnabledInstructionIndex = 0;
        while (matcher.find()) {
            if(isInstructionEnabled(lastEnabledInstructionIndex, matcher.start())) {
                matches.add(matcher.group());
                lastEnabledInstructionIndex = matcher.end();
            }
        }
        return matches;
    }

    private boolean isInstructionEnabled(int lastEnabledInstruction, int startOfCurrentInstruction) {
        String instructionSegment = corruptedInstructions.substring(lastEnabledInstruction, startOfCurrentInstruction);
        return instructionSegment.lastIndexOf("do()") >= instructionSegment.lastIndexOf("don't()");
    }
}
