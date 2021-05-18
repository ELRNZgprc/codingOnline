package leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 * https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class CountTriplets {
    public int countTriplets(int[] arr) {
        int ans = 0;
        int sum = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.computeIfAbsent(0, o -> new ArrayList<Integer>()).add(-1);
        for (int i = 0; i < arr.length; i++) {
            sum ^= arr[i];
            if (map.containsKey(sum)) {
                for (int j : map.get(sum)) {
                    ans += i - j - 1;
                }
                map.get(sum).add(i);
            } else {
                map.computeIfAbsent(sum, o -> new ArrayList<Integer>()).add(i);
            }
        }
        return ans;
    }
}
