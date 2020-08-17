package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class kidsWithCandies {
    /**
     * 1431
     * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();

        int max = 0;
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > candies[max]) {
                max = i;
            }
        }

        for (int i = 0; i < candies.length; i++) {
            ans.add(candies[max] - candies[i] <= extraCandies);
        }

        return ans;
    }
}
