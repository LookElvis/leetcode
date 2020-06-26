package DailyInterview;

import PublicClass.ListNode;
import PublicClass.Utils;
import java.util.HashSet;

/**
 * Created by Elvis on 2020/6/26.
 */
public class Day84 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
//        ListNode l6 = new ListNode(1);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode res = removeDuplicateNodes(head);
        Utils.printLinkedList(res);
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode pHead = pre;
        ListNode cur = head;

        HashSet<Integer> set = new HashSet<>();
        while (cur != null) {
            if (!set.contains(cur.val)) {
                set.add(cur.val);
                pre.next = cur;
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return pHead.next;
    }
}
