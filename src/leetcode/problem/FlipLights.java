package leetcode.problem;

/**
 * 672. 灯泡开关 Ⅱ
 * https://leetcode.cn/problems/bulb-switcher-ii/
 */
public class FlipLights {
    public int flipLights(int n, int presses) {
        if (presses == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return (presses == 1) ? 3 : 4;
        }
        return (presses > 2) ? 8 : (presses == 1) ? 4 : 7;
    }
}
