package Medium;

import PublicClass.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * Created by Elvis on 2020/3/26.
 */
public class M019_Remove_nth_Node {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tNode = new ListNode(-1);
        tNode.next = head;
        ListNode fast = tNode;
        ListNode slow = tNode;
        int t = n;
        while (t >= 0) {
            fast = fast.next;
            t--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return tNode.next;
    }
}
