package com.gowtham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class fileanalyzer {
  
  private static Set<String> keySet;

  public static void main( String []args ){
    String myTextToBeSplit = "This is the text to be split into words."; 
    HashMap<String,Integer> counterMap = new HashMap<String,Integer>(); 
    Scanner s = new Scanner(myTextToBeSplit).useDelimiter("\\s");  
    while( s.hasNext() ) { 
      String val = s.next();
      counterMap.put(val, counterMap.getOrDefault(val,0)+1);
    } 
    s.close(); 
    counterMap.forEach((k,v)-> {
      System.out.println("word = "+k + " ,count ="+v);
    });
  
}

}