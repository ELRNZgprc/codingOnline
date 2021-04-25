package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);
            while (!nodeQueue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                Queue<TreeNode> nodeQueue1 = new LinkedList<>();
                while (!nodeQueue.isEmpty()) {
                    TreeNode node = nodeQueue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        nodeQueue1.add(node.left);
                    }
                    if (node.right != null) {
                        nodeQueue1.add(node.right);
                    }
                }
                ans.add(list);
                nodeQueue = nodeQueue1;
            }
        }

        return ans;
    }
}
