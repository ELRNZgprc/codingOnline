package leetcode.problem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import leetcode.common.TreeNode;

public class FindFrequentTreeSum {
	/**
	 * 508. 出现次数最多的子树元素和
	 * https://leetcode-cn.com/problems/most-frequent-subtree-sum/
	 */
	private int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        Map<Integer,Integer> map = new HashMap<>();
        helper(root,map);
        List<Integer> res = new LinkedList<>();
        for(Integer i : map.keySet()){
            if(map.get(i) == max)
                res.add(i);
        }
        int[] resArr = new int[res.size()];
        for(int i = 0;i < res.size();i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }
    
    private int helper(TreeNode root,Map<Integer,Integer> map){
        if(root == null) return 0;
        int left = helper(root.left,map);
        int right = helper(root.right,map);
        int val = left+right+root.val;
        map.put(val,map.getOrDefault(val,0)+1);
        max = Math.max(max,map.get(val));
        return val;    
    }
}
