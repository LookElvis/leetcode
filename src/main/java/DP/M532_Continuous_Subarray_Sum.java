package DP;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 * Created by Elvis on 2020/3/20.
 */
public class M532_Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            int count = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                count += nums[j];
                if ((k == 0 && count == 0) || (k != 0 && count % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //只要有两个前缀和对k取模相等，说明中间数据的和存在k的倍数
    public boolean checkSubarraySum1(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }
}
