package DailyInterview.Day1_20;

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

    public int findPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findPath(root.left);
        int right = findPath(root.right);
        int res = left + right;
        max = res > max ? res : max;
        return Math.max(left, right) + 1;
    }
}
