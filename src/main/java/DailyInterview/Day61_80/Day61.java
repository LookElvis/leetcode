package DailyInterview.Day61_80;

import PublicClass.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * Created by Elvis on 2020/5/7.
 */
public class Day61 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(s);
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.val == t.val && judge(cur, t)) {
                return true;
            }
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return false;
    }

    public boolean judge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val == t2.val) {
            return judge(t1.left, t2.left) && judge(t1.right, t2.right);
        } else {
            return false;
        }
    }
}
