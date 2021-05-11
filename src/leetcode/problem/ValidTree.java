package leetcode.problem;

import java.util.HashSet;

/**
 * 261. 以图判树
 * https://leetcode-cn.com/problems/graph-valid-tree/
 */
public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        if (edges.length == 0) {
            return true;
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(edges[0][0]);
        set.add(edges[0][1]);

        int add = 1;
        while (add != 0) {
            add = 0;
            for (int[] edge : edges) {
                if ((set.contains(edge[0])) ^ (set.contains(edge[1]))) {
                    add++;
                    set.add(edge[0]);
                    set.add(edge[1]);
                }
            }
        }

        return (set.size() == (edges.length + 1));
    }
}
