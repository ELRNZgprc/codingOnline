package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class TransformArray {
	/**
	 * 1243. 数组变换
	 * https://leetcode-cn.com/problems/array-transformation/
	 */
	public List<Integer> transformArray(int[] arr) {
		List<Integer> plus = new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		for (int i = 1; i < arr.length - 1; i++) {
			if ((arr[i] > arr[i - 1]) && (arr[i] > arr[i + 1])) {
				minus.add(i);
			}
			if ((arr[i] < arr[i - 1]) && (arr[i] < arr[i + 1])) {
				plus.add(i);
			}
		}
		while (!(minus.isEmpty() && (plus.isEmpty()))) {
			while (!minus.isEmpty()) {
				int i = minus.get(0);
				arr[i]--;
				minus.remove((int) 0);
			}
			while (!plus.isEmpty()) {
				int i = plus.get(0);
				arr[i]++;
				plus.remove((int) 0);
			}
			for (int i = 1; i < arr.length - 1; i++) {
				if ((arr[i] > arr[i - 1]) && (arr[i] > arr[i + 1])) {
					minus.add(i);
				}
				if ((arr[i] < arr[i - 1]) && (arr[i] < arr[i + 1])) {
					plus.add(i);
				}
			}
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			ans.add(arr[i]);
		}
		return ans;
	}
}
