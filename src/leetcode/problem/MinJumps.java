package leetcode.problem;

import java.util.*;

/**
 * 1345. 跳跃游戏 IV
 * https://leetcode-cn.com/problems/jump-game-iv/
 */
public class MinJumps {
    public int minJumps(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int[] visited = new int[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            visited[i] = -1;
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        visited[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int step = 0;
        while (queue.size() != 0) {
            step++;
            int length = queue.size();
            while (length > 0) {
                length--;
                int pos = queue.poll();
                if ((pos - 1 >= 0) && (visited[pos - 1] == -1)) {
                    visited[pos - 1] = step;
                    queue.add(pos - 1);
                }
                if ((pos + 1 < arr.length) && (visited[pos + 1] == -1)) {
                    visited[pos + 1] = step;
                    queue.add(pos + 1);
                }
                if (map.containsKey(arr[pos])) {
                    for (int p : map.get(arr[pos])) {
                        if (visited[p] == -1) {
                            visited[p] = step;
                            queue.add(p);
                        }
                    }
                    map.remove(arr[pos]);
                }
                if (visited[arr.length - 1] != -1) {
                    return visited[arr.length - 1];
                }
            }
        }
        return -1;
    }
}
