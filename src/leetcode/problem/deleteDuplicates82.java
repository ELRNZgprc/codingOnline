package leetcode.problem;

import leetcode.common.ListNode;

public class deleteDuplicates82 {
    /**
     * 82
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     */
    public ListNode deleteDuplicates82(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode next = head.next;
        if (head.val == next.val) {
            while ((next != null) && (next.val == head.val)) {
                next = next.next;
            }
            head = deleteDuplicates82(next);
        } else {
            head.next = deleteDuplicates82(next);
        }
        return head;
    }
}
