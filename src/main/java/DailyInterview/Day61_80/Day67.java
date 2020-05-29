package DailyInterview.Day61_80;

import PublicClass.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * Created by Elvis on 2020/5/13.
 */
public class Day67 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list;
        int size;
        queue.add(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            list = new ArrayList<>();
            while (size-- > 0) {
                root = queue.poll();
                list.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
