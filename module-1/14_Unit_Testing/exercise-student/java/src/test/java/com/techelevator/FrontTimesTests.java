package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;

/*
 * Given a string and a non-negative int n, we'll say that the front of the
 * string is the first 3 chars, or whatever is there if the string is less than
 * length 3. Return n copies of the front; frontTimes("Chocolate", 2) →
 * "ChoCho" frontTimes("Chocolate", 3) → "ChoChoCho" frontTimes("Abc", 3) →
 * "AbcAbcAbc"
 */

public class FrontTimesTests {

    FrontTimes exercises = new FrontTimes();

    @Test
    public void stringLongerThan3() {
        assertEquals("Input: \"Chocolate\", 2", "ChoCho", exercises.generateString("Chocolate", 2));
        assertEquals("Input: \"Abc\", 2", "AbcAbc", exercises.generateString("Abc", 2));
        assertEquals("Input: \"Chocolate\", 3", "ChoChoCho", exercises.generateString("Chocolate", 3));
    }

    @Test
    public void stringShorterThan3() {
        assertEquals("Input: \"Ab\", 4", "AbAbAbAb", exercises.generateString("Ab", 4));
        assertEquals("Input: \"r\", 3", "rrr", exercises.generateString("r", 3));
        assertEquals("Input: \"pO\", 3", "pOpOpO", exercises.generateString("pO", 3));
    }

}
