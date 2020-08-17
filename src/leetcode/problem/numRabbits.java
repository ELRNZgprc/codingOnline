package leetcode.problem;

import java.util.Arrays;

public class numRabbits {
    /**
     * 781
     * https://leetcode-cn.com/problems/rabbits-in-forest/
     */
    public int numRabbits(int[] answers) {
        if (answers.length == 0) {
            return 0;
        }
        if (answers.length == 1) {
            return answers[0] + 1;
        }
        int ans = 0;
        Arrays.sort(answers);
        int i = 0;
        while (i < answers.length) {
            int count = 1;
            while ((i + 1 < answers.length) && (answers[i + 1] == answers[i])) {
                i++;
                count++;
            }
            while (count % (answers[i] + 1) != 0) {
                count++;
            }
            ans += count;
            i++;
        }
        return ans;
    }
}
