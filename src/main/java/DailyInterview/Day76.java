package DailyInterview;

import PublicClass.TreeNode;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Created by Elvis on 2020/5/22.
 */
public class Day76 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int target = preorder[0];
        int index = -1;
        TreeNode root = new TreeNode(target);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        int[] preorder1 = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preorder2 = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] inorder1 = Arrays.copyOfRange(inorder, 0, index);
        int[] inorder2 = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        root.left = buildTree(preorder1, inorder1);
        root.right = buildTree(preorder2, inorder2);
        return root;
    }
}
