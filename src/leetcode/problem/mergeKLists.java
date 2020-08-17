package leetcode.problem;

import leetcode.common.ListNode;

public class mergeKLists {
    /**
     * 23
     * https://leetcode-cn.com/problems/merge-k-sorted-lists/
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = lists[0];
        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
}
