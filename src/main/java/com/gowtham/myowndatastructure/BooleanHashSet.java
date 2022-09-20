package com.gowtham.myowndatastructure;

public class BooleanHashSet {
    public final int capacity = 10000;
    boolean arr[];

    public BooleanHashSet(){
        arr = new boolean[capacity];
    }
    
    public void add(int key){
        arr[key]=true;
    }
    public void remove(int key){
        arr[key]=false;
    }
    public boolean contains(int key) {
        return arr[key];
    }
}
