package Interview;

import PublicClass.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/submissions/
 * Created by Elvis on 2020/3/10.
 */
public class Day8 {
    public static void main(String[] args) {

    }

    public int max = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findPath(root);
        return max;
    }

    public void findPath(TreeNode root) {
        if (root != null) {
            int res = longestPath(root.left) + longestPath(root.right);
            max = res > max ? res : max;
            findPath(root.left);
            findPath(root.right);
        }
    }

    public int longestPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(longestPath(root.left), longestPath(root.right)) + 1;
    }
}
