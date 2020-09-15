package leetcode.problem;

import java.util.*;

public class MinimumCost {
    /**
     * 1135. 最低成本联通所有城市
     * https://leetcode-cn.com/problems/connecting-cities-with-minimum-cost/
     */
    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, ((o1, o2) -> o1[2] - o2[2]));
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited = new int[N];
        int parts = 0;
        int ans = 0;
        for (int[] connection : connections) {
            int i = connection[0] - 1;
            int j = connection[1] - 1;
            int cost = connection[2];
            if ((visited[j] == 0) && (visited[i] == 0)) {
                parts++;
                visited[i] = parts;
                visited[j] = parts;
                ans += cost;
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                map.put(parts, list);
            } else if ((visited[i] == 0) || (visited[j] == 0)) {
                if (visited[i] == 0) {
                    visited[i] = visited[j];
                    map.get(visited[j]).add(i);
                } else {
                    visited[j] = visited[i];
                    map.get(visited[i]).add(j);
                }
                ans += cost;
            } else if (visited[i] != visited[j]) {
                int target = Math.min(visited[i], visited[j]);
                int dis = Math.max(visited[i], visited[j]);
                List<Integer> list1 = map.get(dis);
                for (Integer ii : list1) {
                    visited[ii] = target;
                    map.get(target).add(ii);
                }
                map.remove(dis);
                ans += cost;
            }
        }
        return (map.get(1).size() == N) ? ans : -1;
    }
}
