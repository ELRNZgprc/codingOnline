package leetcode.problem;

import java.util.Arrays;

public class NumRescueBoats {
    /**
     * 881. 救生艇
     * https://leetcode-cn.com/problems/boats-to-save-people/
     */
    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        int ans = 0;
        Arrays.sort(people);
        while (i <= j) {
            if (i == j) {
                i++;
                j--;
                ans++;
            } else {
                if (people[i] + people[j] <= limit) {
                    i++;
                    j--;
                    ans++;
                } else {
                    j--;
                    ans++;
                }
            }
        }
        return ans;
    }
}
