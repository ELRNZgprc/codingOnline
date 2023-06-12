package leetcode.problem;

import java.util.Arrays;

/**
 * 1483. 树节点的第 K 个祖先
 * https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/
 */
public class TreeAncestor {
    int[][] p;

    public TreeAncestor(int n, int[] parent) {
        p = new int[17][n];
        p[0] = parent;
        for (int i = 1; i < 17; i++) {
            Arrays.fill(p[i], -1);
            for (int j = 0; j < n; j++) {
                if (p[i - 1][j] != -1) {
                    p[i][j] = p[i - 1][p[i - 1][j]];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 16; i >= 0 && node != -1 && k > 0; i--) {
            if (k >= (1 << i)) {
                k -= (1 << i);
                node = p[i][node];
            }
        }
        return node;
    }
}
