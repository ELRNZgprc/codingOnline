package leetcode.problem;

import leetcode.common.ListNode;

public class deleteDuplicates {
    /**
     * 83
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     */
    public ListNode deleteDuplicates(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) head = head.next;
        return head;
    }
}
