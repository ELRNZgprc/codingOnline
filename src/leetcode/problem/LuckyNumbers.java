package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {
    /**
     * 1380. 矩阵中的幸运数
     * https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] collum = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            row[i] = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                row[i] = Math.min(row[i], matrix[i][j]);
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            collum[j] = matrix[0][j];
            for (int i = 1; i < matrix.length; i++) {
                collum[j] = Math.max(collum[j], matrix[i][j]);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] == collum[j]) {
                    ans.add(collum[j]);
                }
            }
        }
        return ans;
    }
}
