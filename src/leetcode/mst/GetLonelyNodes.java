package leetcode.mst;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1469. 寻找所有的独生节点
 * https://leetcode-cn.com/problems/find-all-the-lonely-nodes/
 */
public class GetLonelyNodes {
    List<Integer> ans;

    public List<Integer> getLonelyNodes(TreeNode root) {
        ans = new ArrayList<>();

        findLonelyNodes(root);

        return ans;
    }

    public void findLonelyNodes(TreeNode root) {
        if (root != null) {
            if ((root.left == null) && (root.right != null)) {
                ans.add(root.right.val);
            }
            if ((root.left != null) && (root.right == null)) {
                ans.add(root.left.val);
            }
            findLonelyNodes(root.left);
            findLonelyNodes(root.right);
        }
    }
}