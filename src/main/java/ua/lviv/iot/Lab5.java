package ua.lviv.iot;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab5 {
    /**
    * The minimum number of words that an exclamatory
    sentence must have in order to be included in the output.
    */
    private static final int MINWORDS = 5;

    /**
    * Removes exclamatory sentences from a given text
    that have less than the specified minimum number of words.
    *
    * @param text the input text to remove exclamatory sentences from
    * @param minWords the minimum number of words
    that an exclamatory sentence must have to be kept in the result
    * @return a string containing the input text
    with exclamatory sentences removed
    */
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
        Pattern pattern = Pattern.compile("[^.!?]+[.!?]");
        Matcher matcher = pattern.matcher(text);
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
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(sentence);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
    * Entry point of the program. Takes an input text,
    removes exclamatory sentences with less than the specified minimum
    * number of words, and prints the resulting text to the console.
    *
    * @param args command-line arguments (not used in this program)
    */
}


