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
        String regex = "mul\\(\\d+,\\d+\\)";
        List<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(corruptedInstructions);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }
}
