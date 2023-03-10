package leetcode.problem;

import java.util.Arrays;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * https://leetcode.cn/problems/pascals-triangle-ii/
 */
public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        Arrays.fill(row, 1);
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                row[j] = row[j] + row[j - 1];
            }
        }
        return Arrays.asList(row);
    }
}
