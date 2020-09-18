package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
	/**
	 * 47. 全排列 II
	 * https://leetcode-cn.com/problems/permutations-ii/
	 */
	 public List<List<Integer>> permuteUnique(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>(); 
	        if (nums == null || nums.length == 0) return res; 
	        int[] visited = new int[nums.length]; 
	        Arrays.sort(nums); 
	        backTrack(res, nums, new ArrayList<Integer>(), visited);
	        return res;
	    }

	    private void backTrack(List<List<Integer>> res, int[] nums, List<Integer> list, int[] visited) {
	        if (list.size() == nums.length) {
	            res.add(new ArrayList<>(list));
	            return ;
	        }
	        for (int i = 0; i < nums.length; i++) {
	            if (visited[i] == 1) continue; 
	            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0){
	                continue;
	            }
	            list.add(nums[i]);
	            visited[i] = 1;
	            backTrack(res, nums, list, visited);
	            visited[i] = 0;
	            list.remove(list.size() - 1);
	        }
	    }
}
