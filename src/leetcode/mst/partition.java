package leetcode.mst;

import leetcode.common.ListNode;

public class partition {
    /**
     * 面试题 02.04
     * https://leetcode-cn.com/problems/partition-list-lcci/
     */
    public ListNode partition(ListNode head, int x) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode small = new ListNode();
        ListNode big = new ListNode();
        ListNode p = head;
        ListNode sp = small;
        ListNode bp = big;
        while (p != null) {
            if (p.val < x) {
                sp.next = p;
                sp = sp.next;
            } else {
                bp.next = p;
                bp = bp.next;
            }
            p = p.next;
        }
        sp.next = big.next;
        bp.next = null;
        return small.next;
    }
}
