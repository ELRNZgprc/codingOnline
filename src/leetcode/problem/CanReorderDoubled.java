package leetcode.problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CanReorderDoubled {
	/**
	 * 954. 二倍数对数组 
	 * https://leetcode-cn.com/problems/array-of-doubled-pairs/
	 */
	public boolean canReorderDoubled(int[] A) {
		Arrays.sort(A);
		Queue<Integer> queue = new LinkedList<>();
		int pos = 0;
		while ((pos < A.length) && (A[pos] < 0)) {
			pos++;
		}
		for (int i = pos - 1; i > -1; i--) {
			if (queue.isEmpty() || (queue.peek() != A[i])) {
				queue.add(2 * A[i]);
			} else {
				queue.poll();
			}
		}
		if (!queue.isEmpty()) {
			return false;
		}
		for (int i = pos; i < A.length; i++) {
			if (queue.isEmpty() || (queue.peek() != A[i])) {
				queue.add(2 * A[i]);
			} else {
				queue.poll();
			}
		}
		return queue.isEmpty();
	}
}
