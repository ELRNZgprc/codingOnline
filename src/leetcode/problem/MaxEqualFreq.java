package leetcode.problem;

/**
 * 1224. 最大相等频率
 * https://leetcode.cn/problems/maximum-equal-frequency/
 */
public class MaxEqualFreq {
    public int maxEqualFreq(int[] nums) {
        int[] hash = new int[100001];
        int max = 0;
        int maxN = 0;
        int ans = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hash[nums[i]] == 0) {
                n++;
            }
            hash[nums[i]]++;
            if (max < hash[nums[i]]) {
                max = hash[nums[i]];
                maxN = 1;
            } else if (max == hash[nums[i]]) {
                maxN++;
            }
            if ((max == 1) || (max * maxN == i) || ((maxN == 1) && (max == i / n + 1))) {
                ans = i + 1;
            }
        }
        return ans;
    }
}
