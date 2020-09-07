package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    /**
     * 77. 组合
     * https://leetcode-cn.com/problems/combinations/
     */
    List<List<Integer>> ans;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        combine(new ArrayList<>(), 1, n, k);
        return ans;
    }

    void combine(List<Integer> list, int begin, int n, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = begin; i < n + list.size() - k + 2; i++) {
                list.add(i);
                combine(list, i + 1, n, k);
                list.remove((Integer) i);
            }
        }
    }
}
