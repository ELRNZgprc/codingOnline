package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    /**
     * 1302. 层数最深叶子节点的和
     * https://leetcode-cn.com/problems/deepest-leaves-sum/
     */
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = root.val;
        int sum = 0;
        int number = 1;
        int sonNumber = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            number--;
            sum += p.val;
            if ((p.left != null)) {
                queue.add(p.left);
                sonNumber++;
            }
            if ((p.right != null)) {
                queue.add(p.right);
                sonNumber++;
            }
            if (number == 0) {
                ans = sum;
                number = sonNumber;
                sum = 0;
                sonNumber = 0;
            }
        }
        return ans;
    }
}
