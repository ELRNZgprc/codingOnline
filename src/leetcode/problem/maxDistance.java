package leetcode.problem;

import java.util.List;

public class maxDistance {
    /**
     * 624
     * https://leetcode-cn.com/problems/maximum-distance-in-arrays/
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int min = 10001;
        int max = -10001;
        int ans = 0;
        for (List<Integer> list : arrays) {
            if (min == 10001) {
                min = list.get(0);
                max = list.get(list.size() - 1);
            } else {
                ans = Math.max(ans, max - list.get(0));
                ans = Math.max(ans, list.get(list.size() - 1) - min);
                max = Math.max(max, list.get(list.size() - 1));
                min = Math.min(min, list.get(0));
            }
        }
        return ans;
    }
}
