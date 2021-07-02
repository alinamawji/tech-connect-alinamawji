package com.techelevator;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;

/*
 * Given an array of strings, return a Dictionary<string, int> with a key for
 * each different string, with the value the number of times that string appears
 * in the array.
 *
 * ** A CLASSIC **
 *
 * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
 * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
 * getCount([]) → {}
 * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
 *
 */

public class WordCountTests {
    WordCount exercises = new WordCount();

    @Test
    public void nullArray() {
        Map<String, Integer> output = exercises.getCount(new String[]{});
        assertThat("Input: {}", output, equalTo(new HashMap<String, Integer>(){}));
    }

    @Test
    public void containsMultipleWords() {
        Map<String, Integer> output = exercises.getCount(new String[]{"ba", "ba", "black", "sheep"});
        assertThat("Input: {\"ba\", \"ba\", \"black\", \"sheep\"}", output, hasEntry("ba", 2));
    }

}
