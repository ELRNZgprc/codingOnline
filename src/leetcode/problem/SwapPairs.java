package leetcode.problem;

import leetcode.common.ListNode;

public class SwapPairs {
	/**
	 * 24. 两两交换链表中的节点
	 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
	}
}
