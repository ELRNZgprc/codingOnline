package leetcode.problem;

/**
 * 2024. 考试的最大困扰度
 * https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/
 */
public class MaxConsecutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int countT = 0;
        int countF = 0;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                countT++;
            } else {
                countF++;
            }
            while ((countF > k) && (countT > k)) {
                if (answerKey.charAt(left) == 'T') {
                    countT--;
                } else {
                    countF--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
