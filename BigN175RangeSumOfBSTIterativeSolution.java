// Time complexity is O(n)
// Space complexity is O(n)
// This solution is submitted on leetcode

import java.util.Stack;
public class BigN175RangeSumOfBSTIterativeSolution {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		public int rangeSumBST(TreeNode root, int L, int R) {
			// edge case
			if (root == null)
				return 0;
			int result = 0;
			Stack<TreeNode> st = new Stack<>();
			while (root != null || !st.isEmpty()) {
				while (root != null) {
					st.push(root);
					if (root.val < L)
						break;
					root = root.left;
				}
				root = st.pop();
				if (root.val >= L && root.val <= R)
					result += root.val;
				if (root.val > R)
					break;
				root = root.right;
			}
			return result;
		}
	}
}