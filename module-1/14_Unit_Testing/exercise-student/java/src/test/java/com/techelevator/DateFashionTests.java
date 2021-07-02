package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;

    /*
    You and your date are trying to get a table at a restaurant. The parameter "you" is the stylishness
    of your clothes, in the range 0..10, and "date" is the stylishness of your date's clothes. The result
    getting the table is encoded as an int value with 0=no, 1=maybe, 2=yes. If either of you is very
    stylish, 8 or more, then the result is 2 (yes). With the exception that if either of you has style of
    2 or less, then the result is 0 (no). Otherwise the result is 1 (maybe).
    dateFashion(5, 10) → 2
    dateFashion(5, 2) → 0
    dateFashion(5, 5) → 1
    */

public class DateFashionTests {
    DateFashion exercises = new DateFashion();

    @Test
    public void atLeastOne8OrHigher() {
        assertEquals("Input: you=5, date=10", 2, exercises.getATable(5, 10));
        assertEquals("Input: you=8, date=8", 2, exercises.getATable(8, 8));
    }

    @Test
    public void atLeastOne2OrLower() {
        assertEquals("Input: you=2, date=1", 0, exercises.getATable(2, 1));
        assertEquals("Input: you=2, date=9", 0, exercises.getATable(2, 8));
    }

    @Test
    public void inBetween3And8() {
        assertEquals("Input: you=5, date=5", 1, exercises.getATable(5, 5));
        assertEquals("Input: you=7, date=4", 1, exercises.getATable(7, 4));
    }
}
