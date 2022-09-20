package com.gowtham.slidingwindow;

public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }

        }

        return maxSum;
    }

    public static int findMinSumSubArray(int k, int[] arr) {
        int windowSum = 0, minLength = Integer.MIN_VALUE, windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
             // shrink the window as small as possible until the 'windowSum' is smaller than 'k'
            while (windowSum >= k) {
                // start with zero from initial index =0 using windowStart as we iterate deduce from the sum by using index
                // reach and move towards the end
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;

            }
        }
        return minLength == Integer.MAX_VALUE ?0:minLength;
    }

}
