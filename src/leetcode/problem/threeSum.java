package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    /**
     * 15
     * https://leetcode-cn.com/problems/3sum/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if ((i == 0) || ((i > 0) && (nums[i] != nums[i - 1]))) {
                int j = i + 1;
                int k = nums.length - 1;
                int target = 0 - nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        ans.add((Arrays.asList(nums[i], nums[j], nums[k])));
                        while ((j < k) && (nums[j + 1] == nums[j])) j++;
                        while ((j < k) && (nums[k - 1] == nums[k])) k--;
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < target) {
                        while ((j < k) && (nums[j + 1] == nums[j])) j++;
                        j++;
                    } else {
                        while ((j < k) && (nums[k - 1] == nums[k])) k--;
                        k--;
                    }
                }
            }
        }

        return ans;
    }
}
