package com.yiibai.tutorial.spring;

import java.util.HashMap;



public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private final HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		for (int i = 0; i < pre.length; ++i) {
			temp.put(in[i], i);
		}
		return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
	}

	public TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
		if (preL > preR) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preL]);
		int inTreeIndex = temp.get(root.val);
		int tempIndex = inTreeIndex - inL;
		root.left = reConstructBinaryTree(pre, preL + 1, preL + tempIndex, inL);
		root.right = reConstructBinaryTree(pre, preL + tempIndex + 1, preR, inL + tempIndex + 1);
		return root;
	}
	
	public static void main(String[] args) {
		int[] pre = {1,2,3,4,5,6,7};
		int[] in = {3,2,4,1,6,5,7};
		Solution s = new Solution();
		s.reConstructBinaryTree(pre, in);
	}
}