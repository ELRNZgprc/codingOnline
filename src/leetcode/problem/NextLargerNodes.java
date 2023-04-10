package leetcode.problem;

import leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1019. 链表中的下一个更大节点
 * https://leetcode.cn/problems/next-greater-node-in-linked-list/
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        ListNode p1 = head;
        List<Integer> res = new ArrayList<>();
        while (p1 != null) {
            ListNode p2 = p1.next;
            boolean isNotFound = true;

            while (p2 != null) {
                if (p1.val < p2.val) {
                    res.add(p2.val);
                    isNotFound = false;
                    break;
                } else {
                    p2 = p2.next;
                }
            }

            if (isNotFound)
                res.add(0);

            p1 = p1.next;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
