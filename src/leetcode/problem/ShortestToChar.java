package leetcode.problem;

public class ShortestToChar {
    /**
     * 821. 字符的最短距离
     * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
     */
    public int[] shortestToChar(String S, char C) {
        int distance = Integer.MAX_VALUE;
        int[] ans = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                distance = 0;
            } else if (distance != Integer.MAX_VALUE) {
                distance++;
            }
            ans[i] = distance;
        }
        distance = Integer.MAX_VALUE;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                distance = 0;
            } else if (distance != Integer.MAX_VALUE) {
                distance++;
            }
            ans[i] = Math.min(distance, ans[i]);
        }
        return ans;
    }
}
