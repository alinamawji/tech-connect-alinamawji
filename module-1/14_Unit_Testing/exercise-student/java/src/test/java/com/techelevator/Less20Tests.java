package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;


/*
 Return true if the given non-negative number is 1 or 2 less than a multiple of 20. So for example 38
 and 39 return true, but 40 returns false.
 (Hint: Think "mod".)
 less20(18) → true
 less20(19) → true
 less20(20) → false
*/

public class Less20Tests {
    Less20 exercises = new Less20();

    @Test
    public void trueInputs() {
        assertEquals("Input: 38", true, exercises.isLessThanMultipleOf20(38));
        assertEquals("Input: 39", true, exercises.isLessThanMultipleOf20(39));
        assertEquals("Input: 18", true, exercises.isLessThanMultipleOf20(18));
    }

    @Test
    public void falseInputs() {
        assertEquals("Input: 40", false, exercises.isLessThanMultipleOf20(40));
        assertEquals("Input: 25", false, exercises.isLessThanMultipleOf20(25));
        assertEquals("Input: 32", false, exercises.isLessThanMultipleOf20(32));
    }
}
