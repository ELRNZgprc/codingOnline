package leetcode.problem;

import leetcode.common.ListNode;

import java.util.Random;

/**
 * 382. 链表随机节点
 * https://leetcode.cn/problems/linked-list-random-node/
 */
public class Solution382 {
    ListNode head;
    Random random;
    public Solution382(ListNode head) {
        this.head=head;
        this.random=new Random();
    }

    public int getRandom() {
        ListNode p=this.head;
        int count=0;
        int res=0;
        while(p!=null){
            count++;
            int randomInt=random.nextInt(count)+1;
            if(randomInt==count){
                res=p.val;
            }
            p=p.next;
        }
        return res;
    }
}
