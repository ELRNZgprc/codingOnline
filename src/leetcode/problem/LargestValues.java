package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LargestValues {
    /**
     * 515. 在每个树行中找最大值
     * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
     */
    List<Integer> ans = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        findLargest(root, 0);
        return ans;
    }

    void findLargest(TreeNode root, int h) {
        if (root != null) {
            if (h >= ans.size()) {
                ans.add(root.val);
            } else {
                ans.set(h, Math.max(root.val, ans.get(h)));
            }
            findLargest(root.left, h + 1);
            findLargest(root.right, h + 1);
        }
    }
}
