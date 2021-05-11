package leetcode.problem;

import leetcode.common.ListNode;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode();
        ListNode p = ans;
        while (head != null) {
            if (head.val != val) {
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }
        p.next = null;
        return ans.next;
    }
}
