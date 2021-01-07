package leetcode.problem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent692 {
	/**
	 * 692. 前K个高频单词
	 * https://leetcode-cn.com/problems/top-k-frequent-words/
	 */
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
			Integer o1Count = map.get(o1);
			Integer o2Count = map.get(o2);
			if (o1Count.equals(o2Count)) {
				return o2.compareTo(o1);
			} else {
				return o1Count - o2Count;
			}
		});
		for (String word : map.keySet()) {
			queue.offer(word);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		LinkedList<String> stack = new LinkedList<>();
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		return stack;
	}
}
