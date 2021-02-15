package com.stringprograms;

import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringOperationsTest {

    @Test
    public void checkFirstNonRepeatCharacterInWord() {
        Character ch = 'd';
        assertEquals(ch, StringOperations.findFirstNonRepeatingCharacter("dishansh"));

        ch = 'p';
        assertEquals(ch, StringOperations.findFirstNonRepeatingCharacter("pishansh"));

        ch = 'x';
        assertEquals(ch, StringOperations.findFirstNonRepeatingCharacter("ssttrrx"));

        ch = '0';
        assertEquals(ch, StringOperations.findFirstNonRepeatingCharacter(""));
    }

    @Test
    public void checkReverseString(){
        assertEquals("mar", StringOperations.reverse("ram"));
        assertEquals("maali", StringOperations.reverse("ilaam"));
        assertEquals("null", StringOperations.reverse("llun"));
        assertEquals(null, StringOperations.reverse(null));

    }
}