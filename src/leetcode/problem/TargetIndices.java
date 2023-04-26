package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2089. 找出数组排序后的目标下标
 * https://leetcode.cn/problems/find-target-indices-after-sorting-array/
 */
public class TargetIndices {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == target){
                list.add(i);
            }
        }
        return list;
    }
}
