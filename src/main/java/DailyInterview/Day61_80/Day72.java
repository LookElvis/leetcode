package DailyInterview.Day61_80;

import PublicClass.Utils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * Created by Elvis on 2020/5/18.
 */
public class Day72 {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tMax = max, tMin = min;
            max = Math.max(nums[i] * tMax, Math.max(nums[i], nums[i] * tMin));
            min = Math.min(nums[i] * tMax, Math.min(nums[i], nums[i] * tMin));
            res = Math.max(res, max);
        }
        return res;
    }

    public int maxProduct1(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        int res = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(nums[i] * max[i - 1], Math.max(nums[i], nums[i] * min[i - 1]));
            min[i] = Math.min(nums[i] * max[i - 1], Math.min(nums[i], nums[i] * min[i - 1]));
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
