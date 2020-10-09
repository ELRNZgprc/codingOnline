package leetcode.problem;

import leetcode.common.ListNode;

public class HasCycle {
	/**
	 * 141. 环形链表
	 * https://leetcode-cn.com/problems/linked-list-cycle/
	 */
	public boolean hasCycle(ListNode head) {
		ListNode slow = head, quick = head;
		while (quick != null && quick.next != null && quick.next.next != null) {
			quick = quick.next.next;
			slow = slow.next;
			if (quick == slow) {
				return true;
			}
		}
		return false;
	}
}
