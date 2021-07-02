package com.techelevator;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

/*
 * Given an array of ints, return true if the array contains no 1's and no 3's.
 * GetLucky([0, 2, 4]) → true GetLucky([1, 2, 3]) → false GetLucky([1, 2,
 * 4]) → false
 */

public class Lucky13Tests {
    Lucky13 exercises = new Lucky13();

    @Test
    public void contains1s() {
        assertEquals("Input: [1, 4, 6, 8]", false, exercises.getLucky(new int[]{1, 4, 6, 8}));
        assertEquals("Input: [9, 6, 5, 1]", false, exercises.getLucky(new int[]{9, 6, 5, 1}));
        assertEquals("Input: [84, 32, 65, 1]", false, exercises.getLucky(new int[]{84, 32, 65, 1}));
    }

    @Test
    public void contains3s() {
        assertEquals("Input: [3, 4, 6, 8]", false, exercises.getLucky(new int[]{3, 4, 6, 8}));
        assertEquals("Input: [9, 6, 5, 3]", false, exercises.getLucky(new int[]{9, 6, 5, 3}));
        assertEquals("Input: [84, 32, 65, 3]", false, exercises.getLucky(new int[]{84, 32, 65, 3}));
    }

    @Test
    public void contains1and3s() {
        assertEquals("Input: [1, 3, 1, 3]", false, exercises.getLucky(new int[]{1, 3, 1, 3}));
        assertEquals("Input: [3, 6, 5, 1]", false, exercises.getLucky(new int[]{3, 6, 5, 1}));
        assertEquals("Input: [84, 3, 65, 1]", false, exercises.getLucky(new int[]{84, 3, 65, 1}));
    }

    @Test
    public void neither1or3s() {
        assertEquals("Input: [10, 11, 15, 33]", true, exercises.getLucky(new int[]{10, 11, 15, 33}));
        assertEquals("Input: [6, 7, 8, 9]", true, exercises.getLucky(new int[]{6, 7, 8, 9}));
        assertEquals("Input: [31, 18, 4, 0]", true, exercises.getLucky(new int[]{31, 18, 4, 0}));
    }
}
