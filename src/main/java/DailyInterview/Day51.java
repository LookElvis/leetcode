package DailyInterview;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * Created by Elvis on 2020/4/24.
 */
public class Day51 {
    public static void main(String[] args) {
        int[] array = new int[] {1,3,2,3,1};
        Day51 dya51 = new Day51();
        dya51.reversePairs(array);
        System.out.println(count);
    }

    public static int count = 0;
    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        sort(nums, 0, nums.length - 1);
        return count;
    }

    public void sort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + ((r - l) >> 1);
        sort(nums, l, m);
        sort(nums, m + 1, r);
        merge(nums, l, r, m) ;
    }

    public void merge(int[] nums, int l, int r, int m) {
        int[] helper = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int index = 0;
        while (p1 <= m && p2 <= r) {
            if (nums[p1] <= nums[p2]) {
                count += p2 - (m + 1);
                helper[index++] = nums[p1++];
            } else {
                helper[index++] = nums[p2++];
            }
        }
        while (p1 <= m) {
            count += p2 - (m + 1);
            helper[index++] = nums[p1++];
        }
        while (p2 <= r) {
            helper[index++] = nums[p2++];
        }
        for (int i = 0; i < helper.length; i++) {
            nums[l + i] = helper[i];
        }
    }
}
