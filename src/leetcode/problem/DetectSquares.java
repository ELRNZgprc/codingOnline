package leetcode.problem;

import java.util.HashSet;

/**
 * 2013. 检测正方形
 * https://leetcode-cn.com/problems/detect-squares/
 */
public class DetectSquares {
    int[][] map = new int[1001][1001];
    HashSet<Integer> x = new HashSet<>();
    HashSet<Integer> y = new HashSet<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        map[point[0]][point[1]]++;
        x.add(point[0]);
        y.add(point[1]);
    }

    public int count(int[] point) {
        int ans = 0;
        if (!x.contains(point[0])) return ans;
        for (int i : y){
            if (map[point[0]][i] != 0) {
                int len = point[1] - i;
                if (len == 0) continue;
                if (point[0] + len >= 0 && point[0] + len < 1001) ans += map[point[0] + len][point[1]] * map[point[0] + len][i] * map[point[0]][i];
                if (point[0] - len >= 0 && point[0] - len < 1001) ans += map[point[0] - len][point[1]] * map[point[0] - len][i] * map[point[0]][i];
            }
        }
        return ans;
    }
}
