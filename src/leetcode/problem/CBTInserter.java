package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * https://leetcode.cn/problems/complete-binary-tree-inserter/
 */
public class CBTInserter {
    TreeNode tree;

    public CBTInserter(TreeNode root) {
        tree = root;
    }

    public int insert(int val) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    //插左边
                    temp.left = new TreeNode(val);
                    result = temp.val;
                    while (!queue.isEmpty()) {
                        queue.poll();
                    }
                    break;
                }
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    result = temp.val;
                    while (!queue.isEmpty()) {
                        queue.poll();
                    }
                    break;
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return result;
    }

    public TreeNode get_root() {
        return tree;
    }
}
