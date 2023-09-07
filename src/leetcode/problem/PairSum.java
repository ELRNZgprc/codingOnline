package leetcode.problem;

import leetcode.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2130. 链表最大孪生和
 * https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/
 */
public class PairSum {
    public int pairSum(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        int max = 0;
        ListNode p = head;
        ListNode q = head;
        while (q != null) {
            deque.push(p);
            p = p.next;
            q = q.next;
            q = q.next;
        }
        while (p != null) {
            max = Math.max(max, deque.pop().val + p.val);
            p = p.next;
        }
        return max;
    }
}
