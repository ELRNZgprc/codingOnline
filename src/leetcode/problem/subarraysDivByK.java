package leetcode.problem;

public class subarraysDivByK {
    /**
     * 974
     * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
     */
    public int subarraysDivByK(int[] A, int K) {
        int[] hash = new int[K];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = (sum + A[i]) % K;
            if (sum < 0)
                sum += K;
            hash[sum]++;
        }

        int ans = hash[0];
        for (int i = 0; i < K; i++) {
            if (hash[i] >= 2) {
                ans += (hash[i] * (hash[i] - 1)) / 2;
            }
        }
        return ans;
    }
}
