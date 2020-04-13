// Time complexity is O(logn+logm)
// Space complexity is O(1)
// This solution is not submitted anywhere

public class BigN174FindingElementInGrid {

	public int[] findElem(int[][] grid) {
		// edge case
		if (grid == null || grid.length == 0)
			return new int[] {};
		int row = grid.length;
		int column = grid[0].length;
		int left = 0;
		int right = column - 1;
		int top = 0;
		int buttom = row - 1;
		int rowIndex = findRowIndex(grid, left, right);
		int columnIndex = findColumnIndex(grid, top, buttom);
		return new int[] { rowIndex, columnIndex };
	}

	private int findRowIndex(int[][] grid, int left, int right) {

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int i = 0;
			int j = mid;
			if ((getResponse(grid, i, j) == "Exact" || getResponse(grid, i, j + 1) != "Hotter")
					&& (getResponse(grid, i, j - 1) != "Hotter")) {
				return mid;
			} else if (getResponse(grid, i, j) == "Hotter") {
				left = mid + 1;
			} else
				right = mid - 1;
		}
		return -1;
	}

	private String getResponse(int[][] grid, int i, int j) {
		return "";
	}

	private int findColumnIndex(int[][] grid, int top, int buttom) {

		while (top <= buttom) {
			int mid = top + (buttom - top) / 2;
			int i = 0;
			int j = mid;
			if ((getResponse(grid, i, j) == "Exact" || getResponse(grid, i + 1, j) != "Hotter")
					&& (getResponse(grid, i - 1, j) != "Hotter")) {
				return mid;
			} else if (getResponse(grid, i, j) == "Hotter") {
				top = mid + 1;
			} else
				buttom = mid - 1;
		}
		return -1;
	}
}