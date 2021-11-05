package leetcode.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1481. 不同整数的最少数目
 * https://leetcode-cn.com/problems/least-number-of-unique-integers-after-k-removals/
 */
public class FindLeastNumOfUniqueInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int[] hash = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            hash[i] = map.get(key);
            i++;
        }
        Arrays.sort(hash);
        i = 0;
        while ((i < hash.length) && (k >= hash[i])) {
            k -= hash[i];
            i++;
        }
        return hash.length - i;
    }
}
