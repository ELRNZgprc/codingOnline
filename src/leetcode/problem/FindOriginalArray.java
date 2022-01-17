package leetcode.problem;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2007. 从双倍数组中还原原数组
 * https://leetcode-cn.com/problems/find-original-array-from-doubled-array/
 */
public class FindOriginalArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[]{};
        }
        Arrays.sort(changed);

        int[] arr = new int[changed.length / 2];
        int x = 0;

        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i : changed) {
            if (!queue.isEmpty() && queue.element() * 2 == i) {
                arr[x] = queue.poll();
                x++;
            } else {
                queue.add(i);
            }
        }

        if (!queue.isEmpty()) {
            return new int[]{};
        }
        return arr;
    }
}
