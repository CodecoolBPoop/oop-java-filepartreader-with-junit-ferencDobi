package com.codecool.filepartreader;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private FilePartReader reader = new FilePartReader();
    private FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);

    @Test
    void wordsArePalindrome() {
        reader.setup("resources/testfile.txt", 6, 11);
        List<String> palindromes = Arrays.asList("ma'am", "rotor", "refer", "rotator",
                "reviver", "Otto", "level", "noon", "I", "eye", "a");
        assertIterableEquals(palindromes, analyzer.wordsArePalindrome());
    }

    @Test
    void wordsByABC() {
        reader.setup("resources/testfile.txt", 5, 6);
        List<String> words = Arrays.asList("also", "can", "guess", "I", "I", "ma'am",
                "need", "on", "palindromes", "please", "rotor", "the", "turn", "you");
        assertIterableEquals(words, analyzer.wordsByABC());
    }

    @Test
    void wordsContainingSubString() {
        reader.setup("resources/testfile.txt", 3, 13);
        assertIterableEquals(Arrays.asList("rotator", "that's", "pirate"), analyzer.wordsContainingSubString("at"));
        assertIterableEquals(Arrays.asList("reviver", "over"), analyzer.wordsContainingSubString("ver"));
    }
}