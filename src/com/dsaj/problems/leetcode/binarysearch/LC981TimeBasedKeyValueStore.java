package com.dsaj.problems.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dsaj.concepts.dsa.utils.ArrayUtils;

/**
 * InnerLC981TimeBasedKeyValueStore
 */
class KeyValueData {
    String key;
    String value;
    int timestamp;

    public KeyValueData(String key, String value, int timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {

    Map<String, List<KeyValueData>> map = new HashMap<>();

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<KeyValueData> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new KeyValueData(key, value, timestamp));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<KeyValueData> list = map.get(key);

        if (list == null) {
            return "";
        }

        int index = findinsertionIndex(list, timestamp);

        if (index == 0) {
            return "";
        }

        if (index == list.size() || list.get(index).timestamp != timestamp) {
            return list.get(index - 1).value;
        }

        return list.get(index).value;
    }

    private int findinsertionIndex(List<KeyValueData> list, int timestamp) {
        int rear = 0;
        int front = list.size() - 1;

        while (rear <= front) {
            int middle = (front + rear) / 2;

            if (list.get(middle).timestamp < timestamp) {
                rear = middle + 1;
            } else {
                front = middle - 1;
            }
        }

        return rear;
    }
}

public class LC981TimeBasedKeyValueStore {

    public static int findinsertionIndex(List<KeyValueData> list, int timestamp) {
        int rear = 0;
        int front = list.size() - 1;

        while (rear <= front) {
            int middle = (front + rear) / 2;

            if (list.get(middle).timestamp < timestamp) {
                rear = middle + 1;
            } else {
                front = middle - 1;
            }
        }

        return rear;
    }

    public static void main(String[] args) {
        List<KeyValueData> map = new ArrayList<>();

        map.add(new KeyValueData("abc", "def", 1));
        map.add(new KeyValueData("abc", "def", 3));
        map.add(new KeyValueData("abc", "def", 3));
        map.add(new KeyValueData("abc", "def", 3));
        map.add(new KeyValueData("abc", "def", 4));

        System.err.println(findinsertionIndex(map, 3));

        // map.add(5, new KeyValueData("abc", "def", 10));

        // ArrayUtils.printList(map);
    }
}
