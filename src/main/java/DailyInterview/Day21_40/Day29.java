package DailyInterview.Day21_40;

import java.util.Random;

/**
 * Created by Elvis on 2020/3/31.
 */
public class Day29 {
    public int[] sortArray(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int[] p = partiton(nums, l, r);
            quickSort(nums, l, p[0] - 1);
            quickSort(nums, p[1] + 1, r);
        }
    }

    public int[] partiton(int[] nums, int l, int r) {
        int pivlot = nums[l + (int) Math.random() * (r - l + 1)];
        int p1 = l - 1;
        int p2 = r + 1;
        while (l < p2) {
            if (nums[l] < pivlot) {
                swap(nums, ++p1, l++);
            } else if (nums[l] > pivlot) {
                swap(nums, --p2, l);
            } else {
                l++;
            }
        }
        return new int[] {p1 + 1, p2 - 1};
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
