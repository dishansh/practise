package com.stringprograms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/*
 * Amazon Interview Question: Find first non-repeating character in a string
 * Assumption : String contains no special character, no spaces and is not a combination of multiple strings
 *
 **/
public class FindFirstNonRepeatedCharacter {

    public static Character findFirstNonRepeatingCharacter(String line) {
        if (line.isEmpty()) { return '0'; }

        LinkedHashMap<Character, Long>
            countMap = line.chars().
            mapToObj(i -> (char) i).
            collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));
        return countMap.entrySet().stream().min(Map.Entry.comparingByValue()).get()
            .getKey();
    }
}
