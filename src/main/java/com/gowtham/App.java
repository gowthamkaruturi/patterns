package com.gowtham;

import com.gowtham.slidingwindow.* ;
import com.gowtham.lru.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       System.out.println(MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2})); 
       System.out.println(MaxSumSubArrayOfSizeK.findMinSumSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 }));
       System.out.println(LongestSubstringKDistinct.CharacterReplacementLongestString("gowtham", 1));
        LRUCache<Integer, Integer> lruCache = new LRUCache<Integer, Integer>(10);

        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        System.out.println(lruCache);
       System.out.println(lruCache.get(6));

       
    }
}
