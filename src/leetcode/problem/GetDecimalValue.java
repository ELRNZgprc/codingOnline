package leetcode.problem;

import leetcode.common.ListNode;

public class GetDecimalValue {
    /**
     * 1290. 二进制链表转整数
     * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
     */
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        ListNode p = head;
        while(p!=null){
            ans*=2;
            ans+=p.val;
            p = p.next;
        }
        return ans;
    }
}
