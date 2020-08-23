package leetcode.mst;

import leetcode.common.ListNode;

public class RemoveDuplicateNodes {
    /**
     * 面试题 02.01. 移除重复节点
     * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        int[] hash = new int[20001];
        ListNode p = head;
        hash[p.val]++;
        ListNode q = p.next;
        while (q != null) {
            if (hash[q.val] != 1) {
                hash[q.val] = 1;
                p = q;
                q = q.next;
            } else {
                p.next = q.next;
                q = q.next;
            }
        }
        return head;
    }
}
