package leetcode.problem;

/**
 * 2165. 重排数字的最小值
 * https://leetcode.cn/problems/smallest-value-of-the-rearranged-number/
 */
public class SmallestNumber {
    public long smallestNumber(long num) {
        boolean flag = num > 0;
        int[] count = new int[10];
        num = Math.abs(num);
        while (num > 0) {
            count[(int) (num % 10)]++;
            num /= 10;
        }
        long ans = 0;
        if (!flag) {
            for (int i = 9; i >= 0; i--) {
                while (count[i] > 0) {
                    ans = ans * 10 + i;
                    count[i]--;
                }
            }
            return -ans;
        }
        if (count[0] > 0) {
            int i = 1;
            while (ans == 0) {
                if (count[i] > 0) {
                    ans = i;
                    count[i]--;
                }
                i++;
            }
        }
        for (int i = 0; i < 10; i++) {
            while (count[i] > 0) {
                ans = ans * 10 + i;
                count[i]--;
            }
        }
        return ans;
    }
}
