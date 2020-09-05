package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderBottom {
    /**
     * 60. 第k个排列
     * https://leetcode-cn.com/problems/permutation-sequence/
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        find(root, 0);
        Collections.reverse(ans);
        return ans;
    }

    void find(TreeNode root, int i) {
        if (root != null) {
            if (ans.size() <= i) {
                ans.add(new ArrayList<>());
            }
            ans.get(i).add(root.val);
            find(root.left, i + 1);
            find(root.right, i + 1);
        }
    }
}
