package leetcode.problem;

import leetcode.common.ListNode;

public class InsertionSortList {
	/**
	 * 147. 对链表进行插入排序
	 * https://leetcode-cn.com/problems/insertion-sort-list/
	 */
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0), pre = dummy, cur = head;
        dummy.next = head;
        while (cur != null) {
            ListNode p = dummy;
            while (p.next.val < cur.val && p.next != cur) {
                p = p.next;
            }
            if (p.next == cur) {
                pre = cur;
                cur = cur.next;
            } else {
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }
        }
        return dummy.next;
	}
}
