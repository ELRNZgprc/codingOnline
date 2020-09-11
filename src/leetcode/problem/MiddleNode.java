package leetcode.problem;

import leetcode.common.ListNode;

public class MiddleNode {
    /**
     * 876. 链表的中间结点
     * https://leetcode-cn.com/problems/middle-of-the-linked-list/
     */
    public ListNode middleNode(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        return p;
    }
}
