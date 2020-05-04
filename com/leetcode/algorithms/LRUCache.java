package com.leetcode.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;


    public LRUCache(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;

    }

    @Override
    public V get(Object key) {
        return super.getOrDefault(key, null);
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}