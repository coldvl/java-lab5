package ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class Lab5Test extends Lab5{
    private Lab5 lab;

    @BeforeEach
    public void setUp() {
        lab = new Lab5();
    }

    @Test
    public void testRemoveExclamatorySentences() {
        String inputText = "Hello, world! This is a test sentence. This is another test sentence. This is a test sentence with 5 words. This is a sentence!";
        String expectedOutput = "This is a test sentence. This is another test sentence. This is a test sentence with 5 words.";
        try {
            assertEquals(expectedOutput, lab.removeExclamatorySentences(inputText, 5));
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testRemoveExclamatorySentencesWithNoExclamations() {
        String inputText = "This is a test sentence. This is another test sentence. This is a test sentence with 5 words.";
        String expectedOutput = "This is a test sentence. This is another test sentence. This is a test sentence with 5 words.";
        try {
            assertEquals(expectedOutput, lab.removeExclamatorySentences(inputText, 5));
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testRemoveExclamatorySentencesWithNotEnoughWords() {
        String inputText = "This is a sentence! This is a test sentence with 5 words.";
        String expectedOutput = "This is a test sentence with 5 words.";
        try {
            assertEquals(expectedOutput, lab.removeExclamatorySentences(inputText, 5));
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testRemoveExclamatorySentencesWithEmptyInput() {
        String inputText = "";
        String expectedOutput = "";
        try {
            assertEquals(expectedOutput, lab.removeExclamatorySentences(inputText, 5));
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testRemoveExclamatorySentencesWithNullInput() {
        String inputText = null;
        try {
            assertThrows(NullPointerException.class, () -> {
                lab.removeExclamatorySentences(inputText, 5);
            });
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }
}
