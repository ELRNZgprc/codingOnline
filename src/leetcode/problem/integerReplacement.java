package leetcode.problem;

public class integerReplacement {
    /**
     * 397
     * https://leetcode-cn.com/problems/integer-replacement/
     */
    public int integerReplacement(int n) {
        long ln = n;
        int ans = 0;
        while (ln != 1) {
            if (((ln & 3) == 3) && (ln != 3)) {
                ln++;
            } else if ((ln & 1) == 1) {
                ln--;
            } else {
                ln = ln >> 1;
            }
            ans++;
        }
        return ans;
    }
}
