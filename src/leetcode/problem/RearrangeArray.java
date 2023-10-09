package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2149. 按符号重排数组
 * https://leetcode.cn/problems/rearrange-array-elements-by-sign/
 */
public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        for (int num : nums) {
            if (num > 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = pos.poll();
            } else {
                res[i] = neg.poll();
            }
        }
        return res;
    }
}
