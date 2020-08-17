package leetcode.mst;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    /**
     * 面试题 08.04
     * https://leetcode-cn.com/problems/power-set-lcci/
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        work0804(nums, 0, list, ans);
        return ans;
    }

    void work0804(int[] nums, int i, List<Integer> list, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
        }
        if (i < nums.length) {
            work0804(nums, i + 1, new ArrayList<>(list), ans);
            list.add(nums[i]);
            work0804(nums, i + 1, new ArrayList<>(list), ans);
        }
    }
}
