package Medium;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * Created by Elvis on 2020/3/28.
 */
class M208_Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public M208_Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char t = word.charAt(i);
            if (cur.child[t - 'a'] == null) {
                cur.child[t - 'a'] = new TrieNode(t);
            }
            cur = cur.child[t - 'a'];
            if (i == word.length() - 1) {
                cur.isEnd = 1;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) {
            return true;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char t = word.charAt(i);
            if (cur.child[t - 'a'] == null) {
                return false;
            } else {
                cur = cur.child[t - 'a'];
            }
        }
        return cur.isEnd == 1;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return true;
        }
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char t = prefix.charAt(i);
            if (cur.child[t - 'a'] == null) {
                return false;
            } else {
                cur = cur.child[t - 'a'];
            }
        }
        return true;
    }
}

class TrieNode {
    char val;
    int isEnd = 0;
    TrieNode[] child = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char val) {
        this.val = val;
    }
}
