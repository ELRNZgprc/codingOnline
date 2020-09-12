package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    /**
     * 637. 二叉树的层平均值
     * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
     */
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> levels = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        levels.add(root);
        while (!levels.isEmpty()) {
            int length = levels.size();
            double sum = 0;
            for (int i = 0; i < length; i++) {
                TreeNode t = levels.poll();
                sum += t.val;
                if (t.left != null) {
                    levels.add(t.left);
                }
                if (t.right != null) {
                    levels.add(t.right);
                }
            }
            ans.add(sum / length);
        }
        return ans;
    }
}
