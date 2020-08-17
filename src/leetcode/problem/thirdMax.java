package leetcode.problem;

public class thirdMax {
    /**
     * 414
     * https://leetcode-cn.com/problems/third-maximum-number/
     */
    public int thirdMax(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int num = 0;
        boolean flag = true;

        for (int i : nums) {
            if (i > a) {
                c = b;
                b = a;
                a = i;
                num++;
            }
            if ((i < a) && (i > b)) {
                c = b;
                b = i;
                num++;
            }
            ;
            if ((i < b) && (i > c)) {
                c = i;
                num++;
            }
            if ((i == Integer.MIN_VALUE) && (flag)) {
                num++;
                flag = false;
            }
        }

        if (num >= 3) {
            return c;
        } else {
            return a;
        }
    }
}
