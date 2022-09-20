package com.gowtham.myowndatastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * what all the API you need
 * add(value)
 * contains(value)
 * remove(value)
 * space and time complexity
 * depends on the table size
 * load factor and rehashing
 * number of buckets ---> num of input (increase the load factor)
 */


public class MyHashSet {

    public static final int capacity = 100000;
    public final int array_size = 100;
    private List<List<Integer>> parent_list;

    public MyHashSet(){
        parent_list = new ArrayList(array_size);
        for(int i=0;i<array_size;i++){
            parent_list.add(null);

        }
    }

    public void add(int key){
        int index = key % array_size;
        List<Integer> childlist = parent_list.get(index);
        if (childlist == null){
            List<Integer>  list = new LinkedList<>();
            list.add(key);
            parent_list.set(index, list);
        }else{
            if(!childlist.contains(key)){
                childlist.add(key);
            }
        }
    }

    public void remove(int key){
        int index = key % array_size;
        List<Integer> childList = parent_list.get(index);
        if(childList != null){
            childList.remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key){
        int index = key % array_size;
        List<Integer> childList = parent_list.get(index);
        
        return childList != null && childList.contains(key);
    }
}
