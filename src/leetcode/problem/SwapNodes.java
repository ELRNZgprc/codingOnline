package leetcode.problem;

import leetcode.common.ListNode;

/**
 * 1721. 交换链表中的节点
 * https://leetcode.cn/problems/swapping-nodes-in-a-linked-list/
 */
public class swapNodes {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        ListNode first = head;
        ListNode last = head;
        int count = 1;
        while (cur.next != null) {
            if (count < k) {
                first = first.next;
            } else {
                last = last.next;
            }
            count++;
            cur = cur.next;
        }
        count = first.val;
        first.val = last.val;
        last.val = count;
        return head;
    }
}
