package com.gowtham.lru;

public class Node<K,V> {

 V value;
 K key;
 Node<K,V> nextNode;
 Node<K,V> prevNode;

public Node(K key, V value, Node<K,V> next,Node<K,V> prev){
    this.key=key;
    this.value=value;
    this.nextNode= next;
    this.prevNode= prev;

}
public Node(){

}

public String toString(){
    return value.toString();
}
    
}
