package leetcode.problem;

import leetcode.common.ListNode;

public class removeZeroSumSublists {
    /**
     * 1171
     * https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode p = new ListNode();
        ListNode pre = p;
        p.next = head;
        while (p != null) {
            ListNode cur = p.next;
            int sum = 0;
            while (cur != null) {
                sum += cur.val;
                cur = cur.next;
                if (sum == 0) {
                    p.next = cur;
                    break;
                }
            }
            if (cur == null) p = p.next;
        }
        return pre.next;
    }
}
