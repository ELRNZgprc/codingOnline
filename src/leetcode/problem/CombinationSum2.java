package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    /**
     * 40. 组合总和 II
     * https://leetcode-cn.com/problems/combination-sum-ii/
     */
    List<List<Integer>> ans;
    List<Integer> memo;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        memo = new ArrayList<>();
        Arrays.sort(candidates);
        dps(candidates, 0, target);
        return ans;
    }

    void dps(int[] candidates, int begin, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(memo));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            memo.add(candidates[i]);
            dps(candidates, i + 1, target - candidates[i]);
            memo.remove(memo.size() - 1);
            while ((i < candidates.length - 1) && (candidates[i + 1] == candidates[i])) {
                i++;
            }
        }
    }
}
