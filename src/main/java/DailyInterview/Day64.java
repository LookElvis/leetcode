package DailyInterview;

import PublicClass.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Created by Elvis on 2020/5/10.
 */
public class Day64 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode res = new TreeNode(-1);
        TreeNode tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            if ((contains(tmp.left, p) && contains(tmp.right, q))
                    || (contains(tmp.left, q) && contains(tmp.right, p))
                    || (tmp == p && ((contains(tmp.left, q) || contains(tmp.right, q))))
                    || (tmp == q && ((contains(tmp.left, p) || contains(tmp.right, p))))
                    ) {
                res = tmp;
                break;
            }
        }
        return res;
    }

    public boolean contains(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return contains(root.left, p) || contains(root.right, p);
    }
}
