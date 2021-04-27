package leetcode.problem;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1331. 数组序号转换
 * https://leetcode-cn.com/problems/rank-transform-of-an-array/
 */
public class ArrayRankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] memo = arr.clone();
        Arrays.sort(memo);

        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : memo) {
            if (map.get(num) == null) {
                count++;
                map.put(num, count);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
