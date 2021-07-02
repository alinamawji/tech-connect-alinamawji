package com.techelevator;
import org.junit.*;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/*
 Given an array of ints, return true if the array is length 1 or more, and the first element and
 the last element are equal.
 IsItTheSame([1, 2, 3]) → false
 IsItTheSame([1, 2, 3, 1]) → true
 IsItTheSame([1, 2, 1]) → true
 */

public class SameFirstLastTests {
    SameFirstLast exercises = new SameFirstLast();

    @Test
    public void emptyArray() {
        assertEquals("Input: []", false, exercises.isItTheSame(new int[]{}));
    }

    @Test
    public void arrayLength1() {
        assertEquals("Input: [5]", true, exercises.isItTheSame(new int[]{5}));
        assertEquals("Input: [3]", true, exercises.isItTheSame(new int[]{3}));
        assertEquals("Input: [85]", true, exercises.isItTheSame(new int[]{85}));
    }

    @Test
    public void firstAndLastNotEqual() {
        assertEquals("Input: [1, 2, 3]", false, exercises.isItTheSame(new int[]{1, 2, 3}));
        assertEquals("Input: [58, 75, 53, 34, 2]", false, exercises.isItTheSame(new int[]{58, 75, 53, 34, 2}));
        assertEquals("Input: [15, 3]", false, exercises.isItTheSame(new int[]{15, 3}));
    }

    @Test
    public void bothConditionsMet() {
        assertEquals("Input: [15, 3, 15]", true, exercises.isItTheSame(new int[]{15, 3, 15}));
        assertEquals("Input: [1, 2, 3, 2, 1]", true, exercises.isItTheSame(new int[]{1, 2, 3, 2, 1}));
        assertEquals("Input: [10, 10]", true, exercises.isItTheSame(new int[]{10, 10}));

    }
}
