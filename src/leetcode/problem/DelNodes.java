package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.*;

/**
 * 1110. 删点成林
 * https://leetcode-cn.com/problems/delete-nodes-and-return-forest/
 */
public class DelNodes {
    Set<Integer> set = new HashSet<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int d : to_delete) {
            set.add(d);
        }
        if (!set.contains(root.val)) {
            ans.add(root);
        }
        dfs(root);
        return ans;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (set.contains(root.val)) {
            if (root.left != null)
                ans.add(root.left);
            if (root.right != null)
                ans.add(root.right);
            root = null;
        }
        return root;
    }
}
