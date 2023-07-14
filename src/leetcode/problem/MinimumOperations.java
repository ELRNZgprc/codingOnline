package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2471. 逐层排序二叉树所需的最少操作数目
 * https://leetcode.cn/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
 */
public class MinimumOperations {
    public int minimumOperations(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] layer = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
                layer[i] = t.val;
            }
            res += count(layer);
        }
        return res;

    }

    public int count(int[] layer) {
        int count = 0;
        for (int i = 0; i < layer.length; i++) {
            int min = i;
            for (int j = i; j < layer.length; j++) {
                if (layer[j] < layer[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = layer[i];
                layer[i] = layer[min];
                layer[min] = temp;
                count++;
            }
        }
        return count;
    }
}
