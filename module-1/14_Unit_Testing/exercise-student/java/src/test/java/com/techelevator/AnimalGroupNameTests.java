package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

/*
 * Given the name of an animal, return the name of a group of that animal
 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
 *
 * The animal name should be case insensitive so "elephant", "Elephant", and
 * "ELEPHANT" should all return "herd".
 *
 * If the name of the animal is not found, null, or empty, return "unknown".
 *
 * Rhino -> Crash
 * Giraffe -> Tower
 * Elephant -> Herd
 * Lion -> Pride
 * Crow -> Murder
 * Pigeon -> Kit
 * Flamingo -> Pat
 * Deer -> Herd
 * Dog -> Pack
 * Crocodile -> Float
 *
 * GetHerd("giraffe") → "Tower"
 * GetHerd("") -> "unknown"
 * GetHerd("walrus") -> "unknown"
 * GetHerd("Rhino") -> "Crash"
 * GetHerd("rhino") -> "Crash"
 * GetHerd("elephants") -> "unknown"
 *
 */

public class AnimalGroupNameTests {

    AnimalGroupName exercises = new AnimalGroupName();

    @Test
    public void knownInputWithVariousFormats() {
        assertEquals("Input: giraffe", "Tower", exercises.getHerd("giraffe"));
        assertEquals("Input: rHiNo", "Crash", exercises.getHerd("rHiNo"));
        assertEquals("Input: Dog", "Pack", exercises.getHerd("Dog"));
        assertEquals("Input: dog", "Pack", exercises.getHerd("dog"));
    }

    @Test
    public void unknownInput() {
        assertEquals("Input: \"\"", "unknown", exercises.getHerd("\"\""));
        assertEquals("Input: walrus", "unknown", exercises.getHerd("walrus"));
        assertEquals("Input: BiRd", "unknown", exercises.getHerd("BiRd"));
    }

}
