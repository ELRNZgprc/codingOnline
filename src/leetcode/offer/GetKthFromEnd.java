package leetcode.offer;

import leetcode.common.ListNode;

public class GetKthFromEnd {
    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < k; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
