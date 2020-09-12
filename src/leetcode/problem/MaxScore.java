package leetcode.problem;

public class MaxScore {
    /**
     * 1423. 可获得的最大点数
     * https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
     */
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        if (k == cardPoints.length) {
            for (int cardPoint : cardPoints) {
                ans += cardPoint;
            }
        } else {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += cardPoints[i];
            }
            ans = sum;
            int left = k - 1;
            int right = cardPoints.length;
            while (left >= 0) {
                sum -= cardPoints[left];
                left--;
                right--;
                sum += cardPoints[right];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
