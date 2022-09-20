package com.gowtham.lru;

import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K, V> {

    private final int maxCapacity;
    private ConcurrentHashMap<K, Node<K, V>> map;
    private Node<K, V> head, tail;
    private int size;

    public LRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.size = 0;
        head = new Node(null, null, null, null);
        tail = new Node(null, null, null, null);
        map = new ConcurrentHashMap(maxCapacity);
        head.nextNode = tail;
        tail.prevNode = head;
    }

    public V get(K key) {
        V result = null;
        Node<K, V> node = map.get(key);
        if (node != null) {
           result = node.value;
           remove(node);
           add(node);
        }

        return result;
    }

    public void put(K key, V value){
        Node node = map.get(key);

        if(node != null){
            remove(node);
            node.value = value;
            add(node);
        } else{
            if (map.size() == maxCapacity){
                map.remove(tail.prevNode.key);
                remove(tail.prevNode);
            }
            Node new_node = new Node();
            new_node.key= key;
            new_node.value = value;
            map.put(key,new_node);
            add(new_node);

        }
    }

    public void add(Node node){
        Node head_next = head.nextNode;
        head.nextNode = node;
        node.prevNode = head;
        node.nextNode = head_next;
        head_next.prevNode = node;
    }
    public void remove(Node node){
        Node next = node.nextNode;
        Node prev = node.prevNode;
        next.prevNode= prev;
        prev.nextNode= next;

    }

}
