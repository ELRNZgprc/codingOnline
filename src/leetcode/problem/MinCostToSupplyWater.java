package leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1168. 水资源分配优化
 * https://leetcode-cn.com/problems/optimize-water-distribution-in-a-village/
 */
public class MinCostToSupplyWater {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{0, i + 1, wells[i]});
        }
        for (int[] p : pipes) {
            list.add(new int[]{p[0], p[1], p[2]});
        }
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o2[2] > o1[2]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        int ans = 0;
        int[] map = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = -1;
        }

        for (int[] pipe : list) {
            int xRoot = getRoot(map, pipe[0]);
            int yRoot = getRoot(map, pipe[1]);
            if (xRoot != yRoot) {
                map[yRoot] = xRoot;
                ans += pipe[2];
            }
        }

        return ans;
    }

    private static int getRoot(int[] map, int x) {
        while (map[x] != -1) {
            x = map[x];
        }
        return x;
    }
}
