package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class partitionLabels {
    /**
     * 763
     * https://leetcode-cn.com/problems/partition-labels/
     */
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        int[][] record = new int[26][2];
        for (int i = 0; i < 26; i++) {
            record[i][1] = S.lastIndexOf(i + 'a');
            record[i][0] = S.indexOf(i + 'a');
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        while (left < S.length()) {
            int right = record[S.charAt(left) - 'a'][1];
            for (int i = left + 1; i < right; i++) {
                right = Math.max(right, record[S.charAt(i) - 'a'][1]);
            }
            ans.add(right - left + 1);
            left = right + 1;
        }

        return ans;
    }
}
