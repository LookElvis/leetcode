package DailyInterview;

import PublicClass.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * Created by Elvis on 2020/4/26.
 */
public class Day53 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode res = new ListNode(-1);
        ListNode head = res;
        ListNode t = new ListNode(-1);
        int min, count, index = 0;
        while (true) {
            min = Integer.MAX_VALUE;
            count = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    count++;
                }
            }
            if (count == n) {
                break;
            }
            for (int i = 0; i < lists.length; i++) {
                t = lists[i];
                if (t != null && t.val < min) {
                    min = t.val;
                    index = i;
                }
            }
//            System.out.println(min + " " + index);
            res.next = new ListNode(min);
            lists[index] = lists[index].next;
            res = res.next;
        }
        return head.next;
    }
}
