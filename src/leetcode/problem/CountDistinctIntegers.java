package leetcode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2442. 反转之后不同整数的数目
 * https://leetcode.cn/problems/count-number-of-distinct-integers-after-reverse-operations/
 */
public class CountDistinctIntegers {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
            int temp = 0;
            while (n > 0) {
                temp = temp * 10 + n % 10;
                n /= 10;
            }
            set.add(temp);
        }
        return set.size();
    }
}
