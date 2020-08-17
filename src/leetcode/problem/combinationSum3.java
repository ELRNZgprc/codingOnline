package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {
    /**
     * 216
     * https://leetcode-cn.com/problems/combination-sum-iii/
     */
    List<List<Integer>> ans216 = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        work216(0, k, n, list);
        return ans216;
    }

    void work216(int begin, int k, int n, List<Integer> list) {
        if (n < 0) {
            return;
        }
        if (k == 0) {
            if (n == 0) {
                ans216.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = begin + 1; i <= Math.min(9, n); i++) {
            list.add(i);
            work216(i, k - 1, n - i, list);
            list.remove(list.size() - 1);
        }
    }
}
