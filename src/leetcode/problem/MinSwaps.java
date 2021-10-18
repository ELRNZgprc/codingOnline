package leetcode.problem;

/**
 * 1151. 最少交换次数来组合所有的 1
 * https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together/
 */
public class MinSwaps {
    public int minSwaps(int[] data) {
        int count = 0;
        for (int num : data) {
            if (num == 1) {
                count++;
            }
        }
        if ((count <= 1) || (count == data.length)) {
            return 0;
        }
        int left = 0;
        int right = count - 1;
        int window = 0;
        for (int i = left; i <= right; i++) {
            if (data[i] == 1) {
                window++;
            }
        }
        int ans = window;
        while (right < data.length - 1) {
            window -= (data[left] == 1) ? 1 : 0;
            left++;
            right++;
            window += (data[right] == 1) ? 1 : 0;
            ans = Math.max(ans, window);
        }
        return count - ans;
    }
}
