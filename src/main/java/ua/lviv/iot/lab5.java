package ua.lviv.iot;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab5 {
    public String removeExclamatorySentences(String text, int minWords) {
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

    private List<String> getSentences(String text) {
        List<String> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^.!?]+[.!?]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group().trim();
            sentences.add(sentence);
        }
        return sentences;
    }

    private boolean isExclamatory(String sentence) {
        return sentence.endsWith("!");
    }

    private int countWords(String sentence) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(sentence);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        lab5 lab = new lab5();
        String text = "Hello, world! This is a test sentence. This is another test sentence. This is a test sentence with 5 words. This is a test sentence with 6 words!";
        System.out.println(lab.removeExclamatorySentences(text, 5));
    }
}


