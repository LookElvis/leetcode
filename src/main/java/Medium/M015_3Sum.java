package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/submissions/
 * Created by Elvis on 2020/3/14.
 */
public class M015_3Sum {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int a, b, c;
        for (a = 0; a < nums.length - 2; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            b = a + 1;
            c = nums.length - 1;
            while (b < c) {
                if (nums[a] + nums[b] + nums[c] < 0) {
                    b++;
                } else if (nums[a] + nums[b] + nums[c] > 0) {
                    c--;
                } else {
                    list.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    while (b < c && nums[b] == nums[b + 1]) {
                        b++;
                    }
                    while (b < c && nums[c] == nums[c - 1]) {
                        c--;
                    }
                    b++;
                    c--;
                }
            }
        }
        return list;
    }
}
