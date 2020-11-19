package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeros {
	/**
	 * 1089. 复写零
	 * https://leetcode-cn.com/problems/duplicate-zeros/
	 */
	public void duplicateZeros(int[] arr) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
		}
		int k = 0;
		while (k < arr.length) {
			arr[k] = queue.poll();
			if (arr[k] == 0) {
				k++;
				if (k < arr.length) {
					arr[k] = 0;
				}
			}
			k++;
		}
	}
}
