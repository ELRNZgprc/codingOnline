package leetcode.problem;

public class MaxChunksToSorted {
    /**
     * 769. 最多能完成排序的块
     * https://leetcode-cn.com/problems/max-chunks-to-make-sorted/
     */
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                ans++;
            }
        }
        return ans;
    }

}
