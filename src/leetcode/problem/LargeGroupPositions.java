package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {
    /**
     * 830. 较大分组的位置
     * https://leetcode-cn.com/problems/positions-of-large-groups/
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while (i < S.length()) {
            int j = i;
            while ((j + 1 < S.length()) && (S.charAt(j + 1) == S.charAt(j))) {
                j++;
            }
            if (j - i > 1) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                ans.add(list);
            }
            i = j + 1;
        }
        return ans;
    }
}
