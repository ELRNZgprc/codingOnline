package leetcode.problem;

public class NumOfSubarrays {
    /**
     * 1524. 和为奇数的子数组数目
     * https://leetcode-cn.com/problems/number-of-sub-arrays-with-odd-sum/
     */
    public int numOfSubarrays(int[] arr) {
        int odd = 0;
        int even = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                int k = 0;
                k = odd;
                odd = even + 1;
                even = k;
            } else {
                even++;
            }
            ans = (ans + odd) % 1000000007;
        }
        return ans;
    }
}
