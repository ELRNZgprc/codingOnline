package leetcode.mst;

import java.util.*;

/**
 * 2512. 奖励最顶尖的 K 名学生
 * https://leetcode.cn/problems/reward-top-k-students/
 */
public class TopStudents {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        int[][] record = new int[student_id.length][2];
        Set<String> positive = new HashSet<>(List.of(positive_feedback));
        Set<String> negative = new HashSet<>(List.of(negative_feedback));
        for (int i = 0; i < student_id.length; i++) {
            int score = 0;
            for (String word : report[i].split(" ")) {
                if (positive.contains(word)) {
                    score += 3;
                }
                if (negative.contains(word)) {
                    score -= 1;
                }
            }
            record[i][0] = student_id[i];
            record[i][1] = score;
        }
        Arrays.sort(record, (a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(record[i][0]);
        }
        return res;
    }
}
