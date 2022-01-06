package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 * https://leetcode-cn.com/problems/VvJkup/
 */
public class Permute {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new boolean[nums.length], 0);
        return results;
    }

    public void dfs(int[] nums, boolean[] visit, int index) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visit[i]) continue;
            visit[i] = true;
            list.add(nums[i]);
            dfs(nums, visit, i + 1);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }
}
