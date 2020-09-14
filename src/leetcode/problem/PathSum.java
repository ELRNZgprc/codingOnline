package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
    /**
     * 437. 路径总和 III
     * https://leetcode-cn.com/problems/path-sum-iii/
     */
    int ans;

    public int pathSum(TreeNode root, int sum) {
        ans = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tn = queue.poll();
            if (tn.left != null) {
                queue.offer(tn.left);
            }
            if (tn.right != null) {
                queue.offer(tn.right);
            }
            findPath(tn, sum);
        }

        return ans;
    }

    void findPath(TreeNode root, int current) {
        if (root != null) {
            if (root.val == current) {
                ans++;
            }
            findPath(root.left, current - root.val);
            findPath(root.right, current - root.val);
        }
    }
}
