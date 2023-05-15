package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1072. 按列翻转得到最大值等行数
 * https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/
 */
public class MaxEqualRowsAfterFlips {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternMap = new HashMap<>();
        for (int[] line : matrix) {
            StringBuilder origin = new StringBuilder();
            StringBuilder convert = new StringBuilder();
            for (int row : line) {
                origin.append(row);
                convert.append((row + 1) % 2);
            }
            String o = origin.toString();
            String c = convert.toString();
            patternMap.put(o, patternMap.getOrDefault(o, 0) + 1);
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (int r : patternMap.values()) {
            ans = Math.max(ans, r);
        }
        return ans;
    }
}
