package DailyInterview.Day41_60;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * Created by Elvis on 2020/4/27.
 */
public class Day54 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = l + ((r - l) >> 1);
        int L, R;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            L = nums[l];
            R = nums[r];
            // 前半段有序
            if (nums[mid] >= L) {
                if (target >= L && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {  //前半段无序，也就是后半段有序
                if (target <= R && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
