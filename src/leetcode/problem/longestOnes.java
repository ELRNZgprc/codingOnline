package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class longestOnes {
    /**
     * 1004
     * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
     */
    public int longestOnes(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int num : A) {
            if (num == 1) {
                count++;
            } else {
                list.add(count);
                count = 0;
            }
        }
        list.add(count);
        if (list.size() <= K) {
            return A.length;
        }
        int ans = 0;
        for (int i = 0; i < K + 1; i++) {
            ans += list.get(i);
        }
        int sum = ans;
        for (int i = 1; i < list.size() - K; i++) {
            sum = sum - list.get(i - 1) + list.get(i + K);
            ans = Math.max(ans, sum);
        }
        return ans + K;
    }


}
