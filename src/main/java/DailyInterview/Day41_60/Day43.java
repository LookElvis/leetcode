package DailyInterview.Day41_60;

import PublicClass.ListNode;
import PublicClass.Utils;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * Created by Elvis on 2020/4/14.
 */
public class Day43 {
    public static void main(String[] args) {
        ListNode h1 = new ListNode(5);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(5);
        ListNode h2 = new ListNode(5);
        ListNode l4 = new ListNode(3);
//        h1.next = l1;
//        l1.next = l2;
//        l2.next = l3;
//        h2.next = l4;
        Day43 day43 = new Day43();
        ListNode res = day43.addTwoNumbers(h1, h2);
        Utils.printLinkedList(res);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = reverse(l1);
        ListNode t2 = reverse(l2);
//        Utils.printLinkedList(t1);
//        Utils.printLinkedList(t2);
        boolean flag = false;
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int tRes = 0;
        int t1R = 0;
        int t2R = 0;
        while (t1 != null || t2 != null) {
            t1R = t1 == null ? 0 : t1.val;
            t2R = t2 == null ? 0 : t2.val;
            tRes = t1R + t2R;
            tRes += flag ? 1 : 0;
            head.next = new ListNode(tRes % 10);
            head = head.next;
            if (tRes >= 10) {
                flag = true;
            } else {
                flag = false;
            }
            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }
        if (flag) {
            head.next = new ListNode(1);
        }
//        Utils.printLinkedList(res);
        return reverse(res.next);
    }

    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
