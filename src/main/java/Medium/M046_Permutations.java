package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列
 * Created by Elvis on 2020/3/31.
 */
public class M046_Permutations {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        process(nums, 0);
        return list;
    }

    public void process(int[] nums, int start) {
        //起始位置到了末尾，这就是一组解
        if (start == nums.length) {
            ArrayList<Integer> tList = new ArrayList<>();
            for (int t : nums) {
                tList.add(t);
            }
            list.add(tList);
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            process(nums, start + 1);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
