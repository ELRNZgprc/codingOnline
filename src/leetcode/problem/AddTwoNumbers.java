package leetcode.problem;

import leetcode.common.ListNode;

public class AddTwoNumbers {
    /**
     * 2. 两数相加
     * https://leetcode-cn.com/problems/add-two-numbers/
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode p = root;
        int flag = 0;
        while ((l1 != null) || (l2 != null) || (flag > 0)) {
            int ans = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + flag;
            flag = ans / 10;
            ans = ans % 10;
            ListNode q = new ListNode(ans);
            p.next = q;
            p = q;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return root.next;
    }
}
