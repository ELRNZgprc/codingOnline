package leetcode.problem;

import leetcode.common.ListNode;

public class rotateRight {
    /**
     * 61
     * https://leetcode-cn.com/problems/rotate-list/
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        p = head;
        ListNode pre = head;
        for (int i = 0; i < length - k; i++) {
            pre = p;
            p = p.next;
        }
        ListNode q = p;
        while (q.next != null) {
            q = q.next;
        }

        q.next = head;
        head = p;
        pre.next = null;

        return head;
    }
}
