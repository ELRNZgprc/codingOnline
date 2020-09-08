package leetcode.offer;

import java.util.Arrays;

public class GetLeastNumbers {
    /**
     * 剑指 Offer 40. 最小的k个数
     * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}
