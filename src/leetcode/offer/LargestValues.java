package leetcode.offer;

import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 044. 二叉树每层的最大值
 * https://leetcode.cn/problems/hPov7L/
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelMax = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                if (tn.left != null) {
                    queue.add(tn.left);
                }
                if (tn.right != null) {
                    queue.add((tn.right));
                }
                levelMax = Math.max(levelMax, tn.val);
            }
            ans.add(levelMax);
        }
        return ans;
    }
}
