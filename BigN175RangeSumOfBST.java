// Time complexity is O(n)
// Space complexity is O(n) of recursive stack space
// This solution is submitted on leetcode

public class BigN175RangeSumOfBST {

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		int result;

		public int rangeSumBST(TreeNode root, int L, int R) {
			// edge case
			if (root == null)
				return 0;
			dfs(root, L, R);
			return result;
		}

		private void dfs(TreeNode root, int L, int R) {
			// base case
			if (root == null)
				return;

			// logic
			if (root.val > L) {
				dfs(root.left, L, R);
			}
			if (root.val >= L && root.val <= R) {
				result += root.val;
			}
			if (root.val < R) {
				dfs(root.right, L, R);
			}
		}
	}
}