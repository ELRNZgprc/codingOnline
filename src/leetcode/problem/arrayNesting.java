package leetcode.problem;

public class arrayNesting {
    /**
     * 565
     * https://leetcode-cn.com/problems/array-nesting/
     */
    public int arrayNesting(int[] nums) {
        int length = nums.length;
        int[] nested = new int[length];
        int max = 0;
        int rings = 0;
        for (int i = 0; i < length; i++) {
            if (nested[i] == 0) {
                rings++;
                int curLength = 0;
                int p = i;
                while (nested[p] == 0) {
                    nested[p] = rings;
                    p = nums[p];
                    curLength++;
                }
                if (curLength > max) {
                    max = curLength;
                }
            }
        }
        return max;
    }
}
