package com.stringprograms;

import org.junit.Assert;
import org.junit.Test;

public class FindFirstNonRepeatedCharacterTest {

    @Test
    public void checkFirstNonRepeatCharacterInWord() {
        Character ch = 'd';
        Assert.assertEquals(ch, FindFirstNonRepeatedCharacter.findFirstNonRepeatingCharacter("dishansh"));

        ch = 'p';
        Assert.assertEquals(ch, FindFirstNonRepeatedCharacter.findFirstNonRepeatingCharacter("pishansh"));

        ch = 'x';
        Assert.assertEquals(ch, FindFirstNonRepeatedCharacter.findFirstNonRepeatingCharacter("ssttrrx"));

        ch = '0';
        Assert.assertEquals(ch, FindFirstNonRepeatedCharacter.findFirstNonRepeatingCharacter(""));
    }
}