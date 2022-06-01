package leetcode.mst;

import leetcode.common.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/
 */
public class KthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode pre = head;
        ListNode ans = head;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }
        while (pre != null) {
            pre = pre.next;
            ans = ans.next;
        }
        return ans.val;
    }
}
