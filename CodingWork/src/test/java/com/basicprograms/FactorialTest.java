package com.basicprograms;

import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {

    @Test
    public void calculateFactorialWhenInputIsZero() {
        Assert.assertEquals(1, Factorial.calculateRecursively(0));
    }

    @Test
    public void calculateFactorialWhenInputIsNonZero() {
        Assert.assertEquals(120, Factorial.calculateRecursively(5));
    }

    @Test
    public void calculateFactorialNRWhenInputIsZero() {
        Assert.assertEquals(1, Factorial.calculateFactorial(0));
    }

    @Test
    public void calculateFactorialNRWhenInputIsNonZero() {
        Assert.assertEquals(120, Factorial.calculateFactorial(5));
    }
}