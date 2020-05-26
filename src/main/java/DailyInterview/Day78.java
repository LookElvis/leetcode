package DailyInterview;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * Created by Elvis on 2020/5/26.
 */
public class Day78 {
    // 快慢指针
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate1(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int mid, count, ans = 0;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            count = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
