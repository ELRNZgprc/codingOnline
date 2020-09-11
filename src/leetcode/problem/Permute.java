package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    /**
     * 46. 全排列
     * https://leetcode-cn.com/problems/permutations/
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] flags = new boolean[nums.length];
        work(nums, flags, new ArrayList<>());
        return ans;
    }

    void work(int[] nums, boolean[] flags, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!flags[i]) {
                    flags[i] = true;
                    list.add(nums[i]);
                    work(nums, flags, list);
                    flags[i] = false;
                    list.remove((Integer) nums[i]);
                }
            }
        }
    }
}
