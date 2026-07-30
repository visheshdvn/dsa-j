package com.dsaj.problems.leetcode.priorityqueue;

import java.util.HashMap;
import java.util.Map;

/**
 * InnerLC146LRUCache
 */
class CacheData {
    int key;
    int value;
    CacheData next;
    CacheData prev;

    public CacheData(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, CacheData> map;
    CacheData auxHead;
    CacheData auxTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);

        auxHead = new CacheData(0, 0);
        auxTail = new CacheData(0, 0);

        auxHead.next = auxTail;
        auxTail.next = auxHead;
    }

    public int get(int key) {
        CacheData node = map.get(key);

        if (node == null) {
            return -1;
        }

        removeNodeFromChain(node);
        markNodeAsRecentlyUsed(node);
        return node.value;
    }

    public void put(int key, int value) {
        CacheData node = map.get(key);
        if (node != null) {
            removeNodeFromChain(node);
            node.value = value;
        } else {
            if (map.size() == capacity) {
                map.remove(auxTail.prev.key);
                removeNodeFromChain(auxTail.prev);
            }

            node = new CacheData(key, value);
            map.put(key, node);
        }
        markNodeAsRecentlyUsed(node);
    }

    // helper methods
    private void removeNodeFromChain(CacheData node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void markNodeAsRecentlyUsed(CacheData node) {
        node.next = auxHead.next;
        auxHead.next.prev = node;

        auxHead.next = node;
        node.prev = auxHead;
    }
}

public class LC146LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

        System.err.println(cache.get(3));
    }
}
