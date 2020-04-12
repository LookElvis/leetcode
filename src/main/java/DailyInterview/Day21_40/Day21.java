package DailyInterview.Day21_40;

import PublicClass.ListNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/submissions/
 * Created by Elvis on 2020/3/23.
 */
public class Day21 {
    // 快慢指针的经典用法，找中间节点
    // 对于1->2->3->4来说会取3作为中间节点
    // 如果需要取2作为中间节点，插入头结点即可
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        return slow;
    }
}
