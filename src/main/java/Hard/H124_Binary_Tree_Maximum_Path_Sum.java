package Hard;

import PublicClass.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * Created by Elvis on 2020/6/21.
 */
public class H124_Binary_Tree_Maximum_Path_Sum {
    public static void main(String[] args) {

    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //当前节点左右子节点的最大贡献
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        maxSum = Math.max(maxSum, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
