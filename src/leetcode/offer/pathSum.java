package leetcode.offer;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class pathSum {
    /**
     * offer 34
     * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
     */
    List<List<Integer>> ans34 = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            work34(root, list, sum, 0);
        }
        return ans34;
    }

    void work34(TreeNode root, List<Integer> list, int sum, int i) {
        if ((root.right == null) && (root.left == null) && (root.val == sum)) {
            list.add(root.val);
            ans34.add(new ArrayList<>(list));
            list.remove(i);
        } else {
            list.add(root.val);
            if (root.left != null) {
                work34(root.left, list, sum - root.val, i + 1);
            }
            if (root.right != null) {
                work34(root.right, list, sum - root.val, i + 1);
            }
            list.remove(i);
        }
    }
}
