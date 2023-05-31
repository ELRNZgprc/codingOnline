package leetcode.problem;

import java.util.HashMap;

/**
 * 1546. 和为目标值且不重叠的非空子数组的最大数目
 * https://leetcode.cn/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 */
public class MaxNonOverlapping {
    public int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int preSum = 0;
        int ans = 0;
        map.put(0, 1);
        for(int i: nums){
            preSum += i;
            if(map.containsKey(preSum - target)){
                ans++;
                map.clear();
            }
            map.put(preSum, 1);
        }
        return ans;
    }
}
