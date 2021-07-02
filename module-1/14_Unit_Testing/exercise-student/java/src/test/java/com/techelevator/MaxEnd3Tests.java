package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

    /*
    Given an array of ints length 3, figure out which is larger between the first and last elements
    in the array, and set all the other elements to be that value. Return the changed array.
    MakeArray([1, 2, 3]) → [3, 3, 3]
    MakeArray([11, 5, 9]) → [11, 11, 11]
    MakeArray([2, 11, 3]) → [3, 3, 3]
    */

public class MaxEnd3Tests {
    MaxEnd3 exercises = new MaxEnd3();

    @Test
    public void differentNums() {
        assertArrayEquals("Input: [1, 2, 3]", new int[]{3, 3, 3}, exercises.makeArray(new int[]{1, 2, 3}));
        assertArrayEquals("Input: [11, 5, 9]", new int[]{11, 11, 11}, exercises.makeArray(new int[]{11, 5, 9}));
        assertArrayEquals("Input: [2, 11, 3]", new int[]{3, 3, 3}, exercises.makeArray(new int[]{2, 11, 3}));
    }

    @Test
    public void sameNums() {
        assertArrayEquals("Input: [10, 10, 10]", new int[]{10, 10, 10}, exercises.makeArray(new int[]{10, 10, 10}));
        assertArrayEquals("Input: [1, 20, 1]", new int[]{1, 1, 1}, exercises.makeArray(new int[]{1, 20, 1}));
        assertArrayEquals("Input: [15, 5, 15]", new int[]{15, 15, 15}, exercises.makeArray(new int[]{15, 5, 15}));

    }

}
