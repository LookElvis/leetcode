package DailyInterview;

import PublicClass.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * Created by Elvis on 2020/5/29.
 */
public class Day81 {
    public int rob(int[] nums) {
        int pre = 0, cur = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(cur, pre + nums[i]);
            pre = cur;
            cur = max;
        }
        return cur;
    }
}
