package leetcode.problem;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class maxLevelSum {
    /**
     * 1161
     * https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/
     */
    public int maxLevelSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        work1161(root, 1, list);
        int ans = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(ans)) {
                ans = i;
            }
        }
        return ans + 1;
    }

    void work1161(TreeNode root, int n, List<Integer> list) {
        if (root != null) {
            if (list.size() < n) {
                int a = 0;
                list.add(a);
            }
            list.set(n - 1, list.get(n - 1) + root.val);
            work1161(root.left, n + 1, list);
            work1161(root.right, n + 1, list);
        }
    }
}
