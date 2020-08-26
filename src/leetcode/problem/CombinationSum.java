package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /**
     * 39. 组合总和
     * https://leetcode-cn.com/problems/combination-sum/
     */
    List<List<Integer>> ans;
    List<Integer> memo;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        memo = new ArrayList<>();
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
            dps(candidates, i, target - candidates[i]);
            memo.remove(memo.size() - 1);
        }
    }
}
