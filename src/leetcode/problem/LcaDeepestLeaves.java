package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1123. 最深叶节点的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/description/
 */
public class LcaDeepestLeaves {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root);
        TreeNode node = root;
        while (true) {
            if (map.get(node.val) == 1) {
                return node;
            }
            if (node.left == null) {
                node = node.right;
                continue;
            }
            if (node.right == null) {
                node = node.left;
                continue;
            }
            if (map.get(node.left.val).equals(map.get(node.right.val))) {
                return node;
            }
            if (map.get(node.left.val) > map.get(node.right.val)) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = Math.max(dfs(root.left), dfs(root.right)) + 1;
        map.put(root.val, level);
        return level;
    }
}
