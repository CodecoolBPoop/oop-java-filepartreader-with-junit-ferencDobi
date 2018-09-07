package com.codecool.filepartreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class FilePartReader {
    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "";
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (fromLine < 1 || fromLine > toLine) throw new IllegalArgumentException();
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String fileString = reader.lines().collect(Collectors.joining( "\n" ));
        reader.close();
        return fileString;
    }

    public String readLines() {
        String fileString = "";
        try {
            fileString = read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lines = fileString.split("\n");
        StringBuilder builder = new StringBuilder();

        for (int i = fromLine; i <= toLine; i++) {
            builder.append(lines[i - 1]);
        }

        return builder.toString();
    }


}
