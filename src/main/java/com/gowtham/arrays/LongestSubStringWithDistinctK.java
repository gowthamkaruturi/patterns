package com.gowtham.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithDistinctK {

  public static int Longest( char[] arr) {

    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charMap = new HashMap<>();

    for (int windowEnd = 0; windowEnd <= arr.length - 1; windowEnd++) {

      char rightChar = arr[windowEnd];

      if (charMap.containsKey(rightChar)) {
        windowStart = Math.max(windowStart, charMap.get(rightChar) + 1);
      }

      charMap.put(arr[windowEnd], windowEnd);
      maxLength = Math.max(maxLength, windowStart - windowEnd + 1);

    }
    charMap.keySet().forEach((Character c ) -> {
      System.out.print(c);
    });
   
    return maxLength;
  }

  public static void main(String[] args) {
    Longest( "aabccbb".toCharArray());
  }
}
