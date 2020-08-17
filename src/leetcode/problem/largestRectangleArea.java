package leetcode.problem;

public class largestRectangleArea {
    /**
     * 84
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length > 0) {
            int max = heights[0];

            for (int i = 0; i < heights.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (heights[j] > heights[i]) {
                        heights[j] = heights[i];
                    }
                }
                for (int j = 0; j <= i; j++) {
                    if ((heights[j] * (i - j + 1)) > max) {
                        max = heights[j] * (i - j + 1);
                    }
                }
            }
            return max;
        } else {
            return 0;
        }
    }
}
