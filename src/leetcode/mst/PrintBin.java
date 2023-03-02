package leetcode.mst;

/**
 * 面试题 05.02. 二进制数转字符串
 * https://leetcode.cn/problems/bianry-number-to-string-lcci/
 */
public class PrintBin {
    public String printBin(double num) {
        double[] a = {0.5, 0.25, 0.125, 0.0625, 0.03125, 0.015625, 0.0078125};
        StringBuilder ans = new StringBuilder();
        ans.append("0.");
        int idx = 0;
        for (int i = 0; i < 7; i++) {
            if (num >= a[i]) {
                num -= a[i];
                ans.append('1');
            } else if (num != .0) ans.append('0');
            else break;
        }
        if (num != 0.0) {
            return "ERROR";
        }
        return ans.toString();
    }
}
