package com.basicprograms;

public class NumericalOperations {

    public static void main(String[] args) {
        int total = 1499;
        int limit = 100;

        double calls = (double) total/limit;
        System.out.println((int)Math.ceil(calls));
    }
}
