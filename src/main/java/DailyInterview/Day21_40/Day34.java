package DailyInterview.Day21_40;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

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
    Map<Integer, Node> cache;
    Map<Integer, LinkedHashSet<Node>> freqMap;
    int capacity;
    int minFreq;  // 最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
        int minFreq = 1;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        // 更新频率
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = cache.get(key);
        if (node == null){
            // 满了，应该移除
            if (cache.size() == capacity){
                removeNode();
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
        } else {
            // 直接覆盖
            node.value = value;
            updateFreq(node);
        }
    }
    /**
     * 更新频率
     */
    public void updateFreq(Node node){
        // 当前缓存的频率
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        // 删除当前频率下的缓存
        set.remove(node);
        // 当前缓存的频率是最小的，并且没有当前频率的缓存了
        if (freq == minFreq && set.size() == 0) minFreq = freq + 1;

        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null){
            newSet = new LinkedHashSet<>();
            freqMap.put(freq+1, newSet);
        }
        newSet.add(node);
    }

    /**
     * 移除最小频率的最后一个节点
     */
    public void removeNode(){
        // 移除频率链表中的节点
        LinkedHashSet<Node> set = freqMap.get(minFreq);
        Node node = set.iterator().next();
        set.remove(node);
        // 移除 cache map 中的节点
        Node cacheNode = cache.get(node.key);
        cache.remove(cacheNode.key);
    }

    /**
     * 添加一个新的节点
     */
    public void addNode(Node node){
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        if (set == null){
            set = new LinkedHashSet<>();
            freqMap.put(node.freq, set);
        }
        set.add(node);
        minFreq = node.freq;
        cache.put(node.key, node);
    }


}
class Node{
    int key;
    int value;
    int freq;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        freq = 1;
    }
}