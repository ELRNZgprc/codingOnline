package leetcode.problem;

import leetcode.common.TreeNode;

public class BuildTree {
	/**
	 * 106. 从中序与后序遍历序列构造二叉树
	 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
	 */
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
	        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
	    }

	    public TreeNode helper(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
	        if (inStart > inEnd) {
	            return null;
	        }

	        int currentVal = postorder[postEnd];
	        TreeNode current = new TreeNode(currentVal);
	        
	        int inIndex = 0; 
	        for (int i = inStart; i <= inEnd; i++) {
	            if (inorder[i] == currentVal) {
	                inIndex = i;
	            }
	        }
	        TreeNode left = helper(inorder, postorder, postEnd - (inEnd- inIndex) - 1, inStart, inIndex - 1);
	        TreeNode right = helper(inorder, postorder, postEnd - 1, inIndex + 1, inEnd);
	        current.left = left;
	        current.right = right;
	        return current;
	    }
}
