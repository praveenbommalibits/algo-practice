package com.algopractice.problemsolving;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUImpl {
    private Deque<Integer> doubleQueue;
    private HashSet<Integer> hashSet;
    private final int CACHE_SIZE;
    public LRUImpl(int capacity) {
        doubleQueue =  new LinkedList<>();
        hashSet =  new HashSet<>();
        CACHE_SIZE = capacity;
    }

    public void refer(int page) {
        if(!hashSet.contains(page)) {
            if (doubleQueue.size() == CACHE_SIZE) {
                int last = doubleQueue.removeLast();
                hashSet.remove(last);
            }
        } else {
            doubleQueue.remove(page);
        }
        doubleQueue.push(page);
        hashSet.add(page);
    }

    public void display() {
        Iterator<Integer> itr = doubleQueue.iterator();
        while(itr.hasNext())
            System.out.println(itr.next() + " ");
    }
    public static void main(String[] args) {
        LRUImpl lru =  new LRUImpl(4);
        lru.refer(1);
        lru.refer(2);
        lru.refer(3);
        lru.refer(1);
        lru.refer(4);
        lru.refer(5);
        lru.refer(2);
        lru.refer(2);
        lru.refer(1);
        lru.display();

    }
}
