package leetcode.problem;

import leetcode.common.ListNode;

import java.util.Stack;

/**
 * 2487. 从链表中移除节点
 * https://leetcode.cn/problems/remove-nodes-from-linked-list/
 */
public class RemoveNodes {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            while (!stack.isEmpty() && stack.peek().val < p.val) {
                stack.pop();
            }
            stack.add(p);
            p = p.next;
        }
        ListNode ans = null;
        while (!stack.isEmpty()) {
            p = stack.pop();
            p.next = ans;
            ans = p;
        }
        return ans;
    }
}
