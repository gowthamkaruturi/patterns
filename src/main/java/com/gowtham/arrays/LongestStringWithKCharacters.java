package com.gowtham.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithKCharacters {

  public static int LongestString(int k, String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
      char rightChar = s.charAt(windowEnd);
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
      while (charFrequencyMap.size() > k) {
        char leftChar = s.charAt(windowStart);
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }


  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestString(2,"araaci"));
  }
}
