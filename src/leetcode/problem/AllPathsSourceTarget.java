package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * https://leetcode.cn/problems/all-paths-from-source-to-target/
 */
public class AllPathsSourceTarget {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph, 0);
        return ans;
    }

    public void dfs(int[][] graph, int node) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = 0; i < graph[node].length; i++) {
            path.add(graph[node][i]);
            dfs(graph, graph[node][i]);
            path.remove(graph[node][i]);
        }
    }
}
