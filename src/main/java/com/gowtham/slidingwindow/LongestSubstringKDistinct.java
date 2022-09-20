package com.gowtham.slidingwindow;

import java.util.HashMap;
import java.util.Map;

import javax.swing.event.InternalFrameAdapter;

public class LongestSubstringKDistinct {

    public static int FindLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap();
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

    public static int FindFruitOfMax2Types(char[] arr) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> fruitFrequencMap = new HashMap<Character, Integer>();

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFrequencMap.put(arr[windowEnd], fruitFrequencMap.getOrDefault(arr[windowEnd], 0) + 1);
            while (fruitFrequencMap.size() > 2) {
                fruitFrequencMap.put(arr[windowStart], fruitFrequencMap.get(arr[windowStart]) - 1);
                if (fruitFrequencMap.get(arr[windowStart]) == 0) {
                    fruitFrequencMap.remove(arr[windowStart]);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static int CharacterReplacementLongestString(String s, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;

        Map<Character, Integer> letterFrequenceMap = new HashMap();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            letterFrequenceMap.put(rightChar, letterFrequenceMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequenceMap.get(rightChar));
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = s.charAt(windowStart);
                letterFrequenceMap.put(leftChar, letterFrequenceMap.get(leftChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;

    }

    public static int FindLengthOfZerosToMakeMoreOnes(int[] arr, int k) {
        int maxLength = 0, windowStart = 0;
        int maxOnes = 0;
        for (int windowEnd = 0; windowStart < arr.length; windowStart++) {
            if (arr[windowEnd] == 1) {
                maxOnes++;
            }
            if (windowEnd - windowStart + 1 - maxOnes > k) {
                if (arr[windowStart] == 1) {
                    maxOnes--;
                    windowStart++;
                }
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static boolean FindPermutation(String s, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<Character, Integer>();

        for (char ch : pattern.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            if (matched == charFrequencyMap.size()) {
                return true;
            }
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = s.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--;
                        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                    }
                }
            }

        }
    return false;
    }
    
}
