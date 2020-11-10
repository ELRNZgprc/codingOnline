package leetcode.problem;

public class CanReach {
	/**
	 * 1306. 跳跃游戏 III
	 * https://leetcode-cn.com/problems/jump-game-iii/
	 */
	boolean[] visited;

	public boolean canReach(int[] arr, int start) {
		visited = new boolean[arr.length];
		return findWay(arr, start);
	}

	boolean findWay(int[] arr, int pos) {
		if ((pos < 0) || (pos >= arr.length)) {
			return false;
		}
		if (arr[pos] == 0) {
			return true;
		}
		if (visited[pos]) {
			return false;
		}
		visited[pos] = true;

		return findWay(arr, pos - arr[pos]) || findWay(arr, pos + arr[pos]);
	}
}
