package leetcode.problem;

public class candy {
    /**
     * 135
     * https://leetcode-cn.com/problems/candy/
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int ans = ratings.length;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i > -1; i--) {
            if ((ratings[i] > ratings[i + 1]) && (candies[i] <= candies[i + 1])) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            ans += candies[i];
        }
        return ans;
    }
}
