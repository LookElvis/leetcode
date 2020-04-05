package DailyInterview;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/lfu-cache/
 * 最不经常使用（LFU）缓存
 * Created by Elvis on 2020/4/5.
 */
public class Day34 {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4

    }
}

class LFUCache {
    LinkedList<Integer> list = new LinkedList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        list.remove(key);
        list.offerLast(key);
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            map.put(key, value);
            if (list.size() >= capacity) {
                list.removeFirst();
            }
            list.offerLast(key);
        } else {
            list.remove(key);
            list.offerLast(key);
            map.put(key, value);
        }
    }
}