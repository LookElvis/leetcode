package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 * Created by Elvis on 2020/3/14.
 */
public class M018_ {
    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int a, b, c, d, add;
        for (a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                add = nums[a] + nums[b];
                c = b + 1;
                d = nums.length - 1;
                while (c < d) {
                    if (add + nums[c] + nums[d] < target) {
                        c++;
                    } else if (add + nums[c] + nums[d] > target) {
                        d--;
                    }  else {
                        list.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }
        return list;
    }
}
