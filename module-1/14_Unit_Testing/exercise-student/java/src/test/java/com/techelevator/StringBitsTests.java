package com.techelevator;
import org.junit.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
 * Given a string, return a new string made of every other char starting with
 * the first, so "Hello" yields "Hlo". GetBits("Hello") → "Hlo" GetBits("Hi")
 * → "H" GetBits("Heeololeo") → "Hello"
 */

public class StringBitsTests {
    StringBits exercises = new StringBits();

    @Test
    public void nullString() {
        assertEquals("Input: ", "", exercises.getBits(""));
    }

    @Test
    public void stringLength1() {
        assertEquals("Input: a", "a", exercises.getBits("a"));
        assertEquals("Input: b", "b", exercises.getBits("b"));
        assertEquals("Input: c", "c", exercises.getBits("c"));
    }

    @Test
    public void stringLengthGreatThan1() {
        assertEquals("Input: Hello", "Hlo", exercises.getBits("Hello"));
        assertEquals("Input: PiZzAsOuNdSgOoD", "PZAONSOD", exercises.getBits("PiZzAsOuNdSgOoD"));
        assertEquals("Input: getBits", "gtis", exercises.getBits("getBits"));
    }

}
