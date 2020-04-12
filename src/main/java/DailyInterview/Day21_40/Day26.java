package DailyInterview.Day21_40;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 * Created by Elvis on 2020/3/28.
 */
public class Day26 {
    public static void main(String[] args) {
        Day26 day26 = new Day26();
        String[] words = new String[] {"time", "me", "bell"};
        System.out.println(day26.minimumLengthEncoding(words));
    }

    public int minimumLengthEncoding(String[] words) {
        int count = 0;
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        Trie t = new Trie();
        for (int i = 0; i < words.length; i++) {
            count += t.insert(words[i]);
        }
        return count;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public int insert(String s) {
        if (s == null) {
            return 0;
        }
        TrieNode cur = root;
        boolean isNew = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char t = s.charAt(i);
            if (cur.next[t - 'a'] == null) {
                isNew = true;
                cur.next[t - 'a'] = new TrieNode(t);
            }
            cur = cur.next[t - 'a'];
        }
        return isNew ? s.length() + 1: 0;
    }
}

class TrieNode {
    int val;
    TrieNode[] next = new TrieNode[26];
    public TrieNode() {
    }
    public TrieNode(int val) {
        this.val = val;
    }
}
