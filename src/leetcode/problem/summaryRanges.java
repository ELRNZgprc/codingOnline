package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class summaryRanges {
    /**
     * 228
     * https://leetcode-cn.com/problems/summary-ranges/
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while ((j + 1 < nums.length) && ((nums[j + 1] - nums[i]) == (j + 1 - i))) {
                j++;
            }
            if (j == i) {
                list.add(nums[i] + "");
            } else {
                list.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return list;
    }
}
