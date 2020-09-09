package leetcode.problem;

public class FindJudge {
    /**
     * 997. 找到小镇的法官
     * https://leetcode-cn.com/problems/find-the-town-judge/
     */
    public int findJudge(int N, int[][] trust) {
        int[] trusted = new int[N + 1];
        int[] trusting = new int[N + 1];
        for (int[] t : trust) {
            trusting[t[0]]++;
            trusted[t[1]]++;
        }
        for (int i = 1; i < N + 1; i++) {
            if ((trusting[i] == 0) && (trusted[i] == N - 1)) {
                return i;
            }
        }
        return -1;
    }
}
