package leetcode.problem;

/**
 * 2380. 二进制字符串重新安排顺序需要的时间
 * https://leetcode.cn/problems/time-needed-to-rearrange-a-binary-string/
 */
public class SecondsToRemoveOccurrences {
    public int secondsToRemoveOccurrences(String s) {
        int ans = 0;
        while (s.contains("01")) {
            s = s.replace("01", "10");
            ans++;
        }
        return ans;
    }
}
