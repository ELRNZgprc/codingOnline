package leetcode.problem;

import leetcode.common.ListNode;

import java.util.*;

public class IsPalindrome234 {
	/**
	 * 234. 回文链表
	 * https://leetcode-cn.com/problems/palindrome-linked-list/
	 */
	public boolean isPalindrome(ListNode head) {
		if ((head == null) || (head.next == null)) {
			return true;
		}
		ListNode p = head;
		ListNode q = head.next;
		Stack<ListNode> stack = new Stack<ListNode>();
		stack.add(p);
		boolean flag = false;
		while (q.next != null) {
			q = q.next;
			if (q.next != null) {
				q = q.next;
				p = p.next;
				stack.add(p);
			} else {
				flag = true;
			}
		}
		if (flag) {
			p = p.next;
		}
		while (p.next != null) {
			p = p.next;
			if (p.val != stack.pop().val) {
				return false;
			}
		}

		return true;
	}
}
