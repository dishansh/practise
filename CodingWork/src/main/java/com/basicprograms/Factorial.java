package com.basicprograms;

public class Factorial {
    // Java 7 procedural style
    public static int calculateFactorial(int n) {
        if (n <= 0) {
            return 1;
        }
        int fact = 1;
        for (int i = n; i > 0; i--) {
            fact = fact * i;
        }
        return fact;
    }

    // Recursive Style
    public static int calculateRecursively(int n) {
        if (n == 0) { return 1; }
        return n * calculateRecursively(n - 1);
    }
}
