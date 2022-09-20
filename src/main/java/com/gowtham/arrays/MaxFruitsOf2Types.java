package com.gowtham.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxFruitsOf2Types {
  public static int FindLengthOf(char []arr){
    int windowStart = 0, maxLength=0;
    Map<Character,Integer> fruitFrequenyMap = new HashMap<>();
    for(int windowEnd =0 ;windowEnd<arr.length-1;windowEnd++){
      fruitFrequenyMap.put(arr[windowEnd], fruitFrequenyMap.getOrDefault(arr[windowEnd], 0)+1);
      while(fruitFrequenyMap.size()>2){
        fruitFrequenyMap.put(arr[windowStart], fruitFrequenyMap.get(arr[windowStart])-1);
        if(fruitFrequenyMap.get(arr[windowStart])==0){
          fruitFrequenyMap.remove(arr[windowStart]);
        }
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd-windowStart+1);
    }
    System.out.println(fruitFrequenyMap);
  
  return maxLength;
  }
  public static void main(String[] args) {
   int length = FindLengthOf(new char[]{'A', 'B', 'C', 'A', 'C'});
   System.out.println(length);
  }
}
