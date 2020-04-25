package DailyInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * Created by Elvis on 2020/4/25.
 */
public class Day52 {
    public static void main(String[] args) {
        int i = 0;
    }

    List<List<Integer>> res = new ArrayList<>();
    int n = 0;
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        n = nums.length;
        generate(list, 0);
        return res;
    }

    public void generate(List<Integer> list, int first) {
        if (first == n) {
            res.add(new ArrayList<>(list));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(list, first, i);
            generate(list, first + 1);
            Collections.swap(list, first, i);
        }
    }
}
