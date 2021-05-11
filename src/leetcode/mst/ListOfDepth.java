package leetcode.mst;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;

import java.util.*;

/**
 * 面试题 04.03. 特定深度节点链表
 * https://leetcode-cn.com/problems/list-of-depth-lcci/
 */
public class ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        List<ListNode> list = new ArrayList<>();
        ListNode dummyHead = new ListNode(-1);
        while (!queue.isEmpty()) {
            ListNode cur = dummyHead;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                tree = queue.poll();
                cur.next = new ListNode(tree.val);
                cur = cur.next;
                if (tree.left != null) {
                    queue.offer(tree.left);
                }
                if (tree.right != null) {
                    queue.offer(tree.right);
                }
            }
            list.add(dummyHead.next);
        }
        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
