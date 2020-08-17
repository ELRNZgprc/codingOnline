package leetcode.problem;

public class isSelfCrossing {
    /**
     * 335
     * https://leetcode-cn.com/problems/self-crossing/
     */
    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4) return false;
        boolean b = false;
        for (int i = 2; i < x.length; i++) {
            if (b && x[i] >= x[i - 2]) return true;
            if (!b && x[i] <= x[i - 2]) {
                b = true;
                if (i < x.length - 1 && x[i + 1] >= x[i - 1]) return true;
                if (i < x.length - 1 && i > 3 && x[i] + x[i - 4] >= x[i - 2] && x[i + 1] + x[i - 3] >= x[i - 1])
                    return true;
                if (i < x.length - 1 && i >= 3 && x[i] == x[i - 2] && x[i + 1] + x[i - 3] >= x[i - 1]) return true;
                i++;
            }
        }
        return false;
    }
}
