package leetcode.problem;

/**
 * 2515. 到目标字符串的最短距离
 * https://leetcode.cn/problems/shortest-distance-to-target-string-in-a-circular-array/
 */
public class ClosetTarget {
    public int closetTarget(String[] words, String target, int startIndex) {
        int ans = 101, N = words.length;
        for (int i = 0; i < N; i++) {
            if (words[i].equals(target)) {
                int abs = Math.abs(startIndex - i);
                ans = Math.min(ans, Math.min(abs, N - abs));
            }
        }
        return ans == 101 ? -1 : ans;
    }
}
