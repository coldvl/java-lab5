package ua.lviv.iot;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab5 {

    public String removeExclamatorySentences(final String text, final int minWords) {
        List<String> sentences = getSentences(text);
        StringBuilder result = new StringBuilder();
        for (String sentence : sentences) {
            if (!isExclamatory(sentence)) {
                result.append(sentence).append(" ");
            } else {
                int wordCount = countWords(sentence);
                if (wordCount >= minWords) {
                    result.append(sentence).append(" ");
                }
            }
        }
        return result.toString().trim();
    }

    private List<String> getSentences(final String text) {
        List<String> sentences = new ArrayList<>();
        Pattern regex = Pattern.compile("[^.!?]+[.!?]");
        Matcher matcher = regex.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group().trim();
            sentences.add(sentence);
        }
        return sentences;
    }

    private boolean isExclamatory(final String sentence) {
        return sentence.endsWith("!");
    }

    private int countWords(final String sentence) {
        Pattern regex = Pattern.compile("\\w+");
        Matcher matcher = regex.matcher(sentence);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}