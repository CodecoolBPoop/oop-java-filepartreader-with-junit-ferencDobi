package com.codecool.filepartreader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordAnalyzer {
    private FilePartReader reader;

    FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    private Stream<String> toStream() {
        return Arrays.stream(reader.readLines().split("//s+"));
    }

    public ArrayList<String> wordsByABC() {
        return toStream().sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> wordsContainingSubString (String subString) {
        return toStream().filter(word -> word.matches(".*" + subString + ".*"))
                         .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> wordsArePalindrome () {
        return toStream().filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                         .collect(Collectors.toCollection(ArrayList::new));
    }
}
