package leetcode.problem;

public class distributeCandies {
    /**
     * 1103
     * https://leetcode-cn.com/problems/distribute-candies-to-people/
     */
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int n = 0;
        while (candies > 0) {
            n++;
            ans[(n - 1) % num_people] += Math.min(candies, n);
            candies -= n;
        }
        return ans;
    }
}
