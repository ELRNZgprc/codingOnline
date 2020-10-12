package leetcode.problem;

import java.util.HashSet;

import leetcode.common.ListNode;

public class DetectCycle {
	/**
	 * 142. 环形链表 II
	 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		HashSet<ListNode> set = new HashSet<>();
		while (!set.contains(head)) {
			set.add(head);
			if (head.next == null)
				return null;
			head = head.next;
		}
		return head;
	}
}
