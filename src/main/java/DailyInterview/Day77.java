package DailyInterview;

import PublicClass.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU
 * https://leetcode-cn.com/problems/lru-cache/
 * Created by Elvis on 2020/5/22.
 */
public class Day77 {

}

class LRUCache {
    Map<Integer, Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        int val = -1;
        if (map.containsKey(key)) {
            val = map.get(key);
            map.remove(key);
            map.put(key, val);
        }
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        if (map.size() == capacity) {
            Iterator<Integer> it = map.keySet().iterator();
            int val = it.next();
            map.remove(val);
        }
        map.put(key, value);
    }
}
