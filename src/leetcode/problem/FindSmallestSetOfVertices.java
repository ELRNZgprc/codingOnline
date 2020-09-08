package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class FindSmallestSetOfVertices {
    /**
     * 1557. 可以到达所有点的最少点数目
     * https://leetcode-cn.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] in = new int[n];
        for (int i = 0; i < edges.size(); i++) {
            in[edges.get(i).get(1)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
