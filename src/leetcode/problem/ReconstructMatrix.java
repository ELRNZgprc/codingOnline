package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class ReconstructMatrix {
    /**
     * 1253. 重构 2 行二进制矩阵
     * https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix/
     */
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int length = colsum.length;
        int[][] temp = new int[2][length];

        for (int i = 0; i < length; i++) {
            if (colsum[i] == 2) {
                upper--;
                lower--;
                temp[0][i] = 1;
                temp[1][i] = 1;
            }
        }
        for (int i = 0; i < length; i++) {
            if (colsum[i] == 1) {
                if (upper != 0) {
                    upper--;
                    temp[0][i] = 1;
                } else {
                    lower--;
                    temp[1][i] = 1;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();

        if (upper != 0 || lower != 0) {
            return ans;
        }

        for (int[] arr : temp) {
            List<Integer> list = new ArrayList<>();
            for (int val : arr) {
                list.add(val);
            }
            ans.add(list);
        }

        return ans;
    }
}
