package com.gowtham.arrays;

import java.util.ArrayList;

import com.gowtham.utils.*;

public class EvenList {

  public static int[] EvenNumbersList(int[] numbers) {

    ArrayList<Integer> evenList = new ArrayList<Integer>();

    for (int n : numbers) {
      if (utils.isEven(n)) {
        evenList.add(n);
      }
    }
    int[] response = new int[evenList.size() - 1];

    for (int i = 0; i < evenList.size(); i++) {

      response[i] = evenList.get(i);

    }
    return response;
  }

}
