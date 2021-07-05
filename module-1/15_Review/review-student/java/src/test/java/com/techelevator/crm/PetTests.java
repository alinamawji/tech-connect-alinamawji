package com.techelevator.crm;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PetTests {

    Pet minnie = new Pet("Minnie", "Maine Coon");

    @Test
    public void noVaccinations() {
        assertEquals("No vaccinations", "", minnie.listVaccinations());
        assertEquals("No vaccinations", "", minnie.listVaccinations());
    }

    @Test
    public void listOfVaccinations() {
        minnie.setVaccinations(new ArrayList<String>(Arrays.asList("vaccine1", "vaccine2", "vaccine3", "vaccine4", "vaccine5")));
        assertEquals("Input: vaccine1, vaccine2, vaccine3, vaccine4, vaccine5", "vaccine1, vaccine2, vaccine3, vaccine4, vaccine5", minnie.listVaccinations());
    }

}
