package leetcode.problem;

public class maxScoreSightseeingPair {
    /**
     * 1014
     * https://leetcode-cn.com/problems/best-sightseeing-pair/
     */
    public int maxScoreSightseeingPair(int[] A) {
        int ans = -1;
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            int mem = max + A[i] - i;
            if ((ans == -1) || (mem > ans)) {
                ans = mem;
            }
            if (A[i] + i > max) {
                max = A[i] + i;
            }
        }
        return ans;
    }
}
