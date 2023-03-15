package leetcode.problem;

import leetcode.common.ListNode;

import java.util.Stack;

/**
 * 445. 两数相加 II
 * https://leetcode.cn/problems/add-two-numbers-ii/
 */
public class AddTwoNumbers445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            carry = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;
        }
        return head;
    }
}
