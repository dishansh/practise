package com.stringprograms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class StringOperations {

    /*
     * Amazon Interview Question: Find first non-repeating character in a string
     * Assumption : String contains no special character, no spaces and is not a combination of multiple strings
     *
     **/
    public static Character findFirstNonRepeatingCharacter(String line) {
        if (line.isEmpty()) { return '0'; }

        LinkedHashMap<Character, Long>
            countMap = line.chars().
            mapToObj(i -> (char) i).
            collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()));
        return countMap.entrySet().stream().min(Map.Entry.comparingByValue()).get()
            .getKey();
    }

    /**
     * Reverse a string without using library function
     *
     * */

    public static String reverse(String line){
        StringBuilder sb = new StringBuilder();
        if(line == null){
            return null;
        }
        if(!line.isEmpty()){
            char[] charArray = line.toCharArray();
            for(int i=charArray.length-1; i >= 0 ; i--){
                sb.append(charArray[i]);
            }
        }
        return sb.toString();

        // Other way can be using StringBuilder's reverse() method
        // return new StringBuilder(line).reverse().toString();
    }

    public static String findLongestSubstringWithoutRepeatition(String word) {

        // abcabcabde -> abc
        if(word.length() < 2) {
            return word;
        }

        int start = 0;
        int end = 0;
        String longestSubString = "";
        List<Character> iteratedString = new ArrayList<>();
        while(end < word.length()) {
            iteratedString.add(word.charAt(end));
            if(iteratedString.contains(word.charAt(end))) {
                System.out.println(iteratedString);
                if(word.substring(start, end).length() > longestSubString.length()) {
                    longestSubString = word.substring(start, end);
                }
                start = end;
                iteratedString.clear();
                iteratedString.add(word.charAt(end));
            }
            end++;
        }
        System.out.println(iteratedString);
        return iteratedString.size() > longestSubString.length() ? iteratedString.toString() : longestSubString;
    }
}
