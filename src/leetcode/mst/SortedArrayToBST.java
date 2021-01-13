package leetcode.mst;

import leetcode.common.TreeNode;

public class SortedArrayToBST {
	/**
	 * 面试题 04.02. 最小高度树
	 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length);
    }
    private TreeNode helper(int[] nums,int left,int right){
        if(left==right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,left,mid);
        node.right = helper(nums,mid+1,right);
        return node;
    }
}
