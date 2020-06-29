package Medium;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * Created by elvisxliu
 * date: 2020/6/29
 */
public class M215_kth_largest_element_in_an_array {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) ->(b - a));
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}
