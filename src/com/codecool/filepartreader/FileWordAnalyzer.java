package com.codecool.filepartreader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordAnalyzer {
    private FilePartReader reader;

    FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    private Stream<String> toStream() {
        return Arrays.stream(reader.readLines().split("[^\\w']+"));
    }

    public List<String> wordsByABC() {
        return toStream().sorted(Comparator.comparing(String::toLowerCase))
                         .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> wordsContainingSubString(String subString) {
        return toStream().filter(word -> word.matches(".*" + subString + ".*"))
                         .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> wordsArePalindrome() {
        return toStream().filter(this::isPalindrome)
                         .collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean isPalindrome(String word) {
        return word.toLowerCase().equals(new StringBuilder(word).reverse().toString().toLowerCase());
    }
}
