package com.gowtham.arrays;

public class MinSubArraySum {

  public static int BruteForce(int sum, int[] arr) {
    int min_len = arr.length + 1;
    int windowSum;
    for (int start = 0; start < arr.length; start++) {
      windowSum = arr[start];
      if (windowSum > sum) {
        return 1;
      }
      for (int end = start + 1; end < arr.length; end++) {
        windowSum += arr[end];

        if (windowSum > sum && (end - start + 1) < min_len) {
          min_len = end - start;

        }
      }
    }
    return min_len;
  }

  public static int NonBruteForce(int sum, int[] arr) {

    int lengthOfSmallestSubArray = Integer.MAX_VALUE;
    int windowSum = 0;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd <= arr.length - 1; windowEnd++) {

      windowSum += arr[windowEnd];
      while (windowSum >= sum) {
        lengthOfSmallestSubArray = Math.min(lengthOfSmallestSubArray, windowEnd - windowStart + 1);
        windowSum -= arr[windowStart];
        windowStart++;

      }

    }
    return lengthOfSmallestSubArray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubArray;

  }

  public static void main(String[] args) {
    int response = BruteForce(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Brute Force min size sub array  is --> " + response);
    response = NonBruteForce(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Non Brute Force min size sub array  is --> " + response);
  }
}
