package leetcode.lcs;

import java.util.Arrays;

/**
 * LCS 02. 完成一半题目
 * https://leetcode-cn.com/problems/WqXACV/
 */
public class HalfQuestions {
    public int halfQuestions(int[] questions) {
        int[] record = new int[1001];

        for (int q : questions) {
            record[q]++;
        }
        Arrays.sort(record);
        int target = questions.length / 2;
        int ans = 0;
        while (target > 0) {
            ans++;
            target -= record[1001 - ans];
        }
        return ans;
    }
}
