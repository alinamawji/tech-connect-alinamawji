package com.techelevator;
import org.junit.*;
import static org.junit.Assert.*;

public class CigarPartyTests {


    /*
     When squirrels get together for a party, they like to have cigars. A squirrel party is successful
     when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case
     there is no upper bound on the number of cigars. Return true if the party with the given values is
     successful, or false otherwise.
     haveParty(30, false) → false
     haveParty(50, false) → true
     haveParty(70, true) → true
     */

    CigarParty exercises = new CigarParty();

    @Test
    public void isNotWeekend() {
        assertEquals("Input: cigarParty(30, false)", false, exercises.haveParty(30, false));
        assertEquals("Input: cigarParty(50, false)", true, exercises.haveParty(50, false));
        assertEquals("Input: cigarParty(70, false)", false, exercises.haveParty(70, false));
        assertEquals("Input: cigarParty(60, false)", true, exercises.haveParty(60, false));
        assertEquals("Input: cigarParty(10, false)", false, exercises.haveParty(10, false));
    }

    @Test
    public void isWeekend() {
        assertEquals("Input: cigarParty(100, true)", true, exercises.haveParty(100, true));
        assertEquals("Input: cigarParty(10, true)", false, exercises.haveParty(10, true));
        assertEquals("Input: cigarParty(70, true)", true, exercises.haveParty(70, true));
    }

}
