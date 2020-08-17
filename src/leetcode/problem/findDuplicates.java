package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class findDuplicates {
    /**
     * 442
     * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
     */
    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % nums.length] += nums.length;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 2 * nums.length) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
