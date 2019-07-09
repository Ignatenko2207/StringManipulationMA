package com.mainacad.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizerTest {

    @Test
    void testGetRandomNumber() {
        Integer testNumber = Randomizer.getRandomNumber(50, 100);
        assertNotNull(testNumber);
        assertTrue(testNumber >= 50 & testNumber <= 100);
    }

    @Test
    void getRandomString() {
        String testString = Randomizer.getRandomString(20);
        assertNotNull(testString);
        assertEquals(20, testString.length());
    }
}