package com.codecool.filepartreader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private FilePartReader reader;

    @BeforeEach
    void setUp() {
        reader = new FilePartReader();
    }

    @Test
    void readThrowsExceptionWhenNoFileIsSpecified() {
        assertThrows(FileNotFoundException.class, () -> new FilePartReader().read());
    }

    @Test
    void setupThrowsExceptionWhenFromLineIsZero() {
        assertThrows(IllegalArgumentException.class,
                () -> reader.setup("resources/testfile.txt", 0, 2));
    }

    @Test
    void setupThrowsExceptionWhenFromLineIsBiggerThanToLine() {
        assertThrows(IllegalArgumentException.class,
                () -> reader.setup("resources/testfile.txt", 3, 2));
    }

    @Test
    void readLinesReturnsTheCorrectLines() {
        reader.setup("resources/testfile.txt", 2, 4);
        assertEquals("beware!!! empty line above\nlots of writing", reader.readLines());
        reader.setup("resources/testfile.txt", 7, 7);
        assertEquals("and refer to the rotator as the reviver from now on", reader.readLines());
    }

}