package com.techelevator;
import org.junit.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
 Given 2 strings, return their concatenation, except omit the first char of each. The strings will
 be at least length 1.
 GetPartialString("Hello", "There") → "ellohere"
 GetPartialString("java", "code") → "avaode"
 GetPartialString("shotl", "java") → "hotlava"
 */

public class NonStartTests {
    NonStart exercises = new NonStart();

    @Test
    public void aLength0() {
        assertEquals("Input: a= b=hi", "i", exercises.getPartialString("", "hi"));
        assertEquals("Input: a= b=h", "", exercises.getPartialString("", "h"));
        assertEquals("Input: a= b=hello", "ello", exercises.getPartialString("", "hello"));
    }

    @Test
    public void bLength0() {
        assertEquals("Input: a=hi b= ", "i", exercises.getPartialString("hi", ""));
        assertEquals("Input: a=h b= ", "", exercises.getPartialString("h", ""));
        assertEquals("Input: a=hello b= ", "ello", exercises.getPartialString("hello", ""));
    }

    @Test
    public void aAndBLengthGreaterThan0() {
        assertEquals("Input: a=hello b=hi", "elloi", exercises.getPartialString("hello", "hi"));
        assertEquals("Input: a=candy, b=chocolate", "andyhocolate", exercises.getPartialString("candy", "chocolate"));
        assertEquals("Input: a=ice b=cream", "ceream", exercises.getPartialString("ice", "cream"));
    }
}
