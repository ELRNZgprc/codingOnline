package leetcode.problem;

import java.util.HashMap;

public class GridIllumination {
    /**
     * 1001. 网格照明
     * https://leetcode-cn.com/problems/grid-illumination/
     */
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
//        //方法1 超时
//        int[][] grid = new int[N][N];
//        boolean[][] light = new boolean[N][N];
//        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
//        for (int[] lamp : lamps) {
//            light[lamp[0]][lamp[1]] = true;
//            grid[lamp[0]][lamp[1]]++;
//            for (int[] direction : directions) {
//                int x = lamp[0];
//                int y = lamp[1];
//                while (((x + direction[0]) < N) && ((x + direction[0]) > -1) && ((y + direction[1]) < N) && ((y + direction[1]) > -1)) {
//                    x += direction[0];
//                    y += direction[1];
//                    grid[x][y]++;
//                }
//            }
//        }
//        int[] ans = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            int x = queries[i][0];
//            int y = queries[i][1];
//            ans[i] = (grid[x][y] > 0) ? 1 : 0;
//            int[][] targets = {{x, y}, {x, y + 1}, {x, y - 1}, {x + 1, y}, {x - 1, y}, {x - 1, y - 1}, {x - 1, y + 1}, {x + 1, y - 1}, {x + 1, y - 1}};
//            for (int[] target : targets) {
//                if ((target[0] < N) && (target[0] > -1) && (target[1] < N) && (target[1] > -1)) {
//                    if (light[target[0]][target[1]]) {
//                        light[target[0]][target[1]] = false;
//                        for (int[] direction : directions) {
//                            int xx = target[0];
//                            int yy = target[1];
//                            while (((xx + direction[0]) < N) && ((xx + direction[0]) > -1) && ((yy + direction[1]) < N) && ((yy + direction[1]) > -1)) {
//                                xx += direction[0];
//                                yy += direction[1];
//                                grid[xx][yy]--;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return ans;

        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> clum = new HashMap<>();
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<String, Boolean> lights = new HashMap<>();
        for (int[] lamp : lamps) {
            row.put(lamp[0], row.containsKey(lamp[0]) ? row.get(lamp[0]) + 1 : 1);
            clum.put(lamp[1], clum.containsKey(lamp[1]) ? clum.get(lamp[1]) + 1 : 1);
            left.put(lamp[0] + lamp[1], left.containsKey(lamp[0] + lamp[1]) ? left.get(lamp[0] + lamp[1]) + 1 : 1);
            right.put(lamp[0] - lamp[1] + N - 1, right.containsKey(lamp[0] - lamp[1] + N - 1) ? right.get(lamp[0] - lamp[1] + N - 1) + 1 : 1);
            String s = lamp[0] + "+" + lamp[1];
            lights.put(s, true);
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            ans[i] = (row.containsKey(x) || clum.containsKey(y) || left.containsKey(x + y) || right.containsKey(x + N - 1 - y)) ? 1 : 0;
            int[][] targets = {{x, y}, {x, y + 1}, {x, y - 1}, {x + 1, y}, {x - 1, y}, {x - 1, y - 1}, {x - 1, y + 1}, {x + 1, y - 1}, {x + 1, y - 1}};
            for (int[] target : targets) {
                String s = target[0] + "+" + target[1];
                if (lights.containsKey(s)) {
                    lights.remove(s);
                    if (row.get(target[0]) == 1) {
                        row.remove(target[0]);
                    } else {
                        row.put(target[0], row.get(target[0]) - 1);
                    }
                    if (clum.get(target[1]) == 1) {
                        clum.remove(target[1]);
                    } else {
                        clum.put(target[1], clum.get(target[1]) - 1);
                    }
                    if (left.get(target[0] + target[1]) == 1) {
                        left.remove(target[0] + target[1]);
                    } else {
                        left.put(target[0] + target[1], left.get(target[0] + target[1]) - 1);
                    }
                    if (right.get(target[0] + N - 1 - target[1]) == 1) {
                        right.remove(target[0] + N - 1 - target[1]);
                    } else {
                        right.put(target[0] + N - 1 - target[1], right.get(target[0] + N - 1 - target[1]) - 1);
                    }
                }
            }
        }
        return ans;
    }
}
