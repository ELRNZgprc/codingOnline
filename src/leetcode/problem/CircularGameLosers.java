package leetcode.problem;

/**
 * 2682. 找出转圈游戏输家
 * https://leetcode.cn/problems/find-the-losers-of-the-circular-game/
 */
public class CircularGameLosers {
    public int[] circularGameLosers(int n, int k) {
        // 接球次数
        int[] times = new int[n];
        // 当前接球人下标
        int index = 0;
        // 当前步数
        int step = 0;
        // 结果数组长度
        int resLen = n;
        while (true) {
            if (times[index] == 0) {
                --resLen;
            }
            times[index] += 1;
            if (times[index] == 2) {
                break;
            }
            index = (index + k * ++step) % n;
        }
        int[] res = new int[resLen];
        int resIndex = 0;
        for (int i = 0; i < n; i++) {
            if (times[i] == 0) {
                res[resIndex++] = i + 1;
            }
        }
        return res;
    }
}
