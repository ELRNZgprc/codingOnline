package leetcode.problem;

import leetcode.common.ListNode;

public class GetIntersectionNode {
    /**
     * 160. 相交链表
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if ((headA == null) || (headB == null)) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        boolean aEnd = false;
        boolean bEnd = false;
        boolean findEnd = true;
        while (findEnd) {
            if (a == b) {
                return a;
            }
            if (a.next != null) {
                a = a.next;
            } else if (aEnd) {
                findEnd = false;
            } else {
                aEnd = true;
                a = headB;
            }
            if (b.next != null) {
                b = b.next;
            } else if (bEnd) {
                findEnd = false;
            } else {
                bEnd = true;
                b = headA;
            }
        }
        return null;
    }
}
