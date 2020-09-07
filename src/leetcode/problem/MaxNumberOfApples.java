package leetcode.problem;

import java.util.Arrays;

public class MaxNumberOfApples {
    /**
     * 1196. 最多可以买到的苹果数量
     * https://leetcode-cn.com/problems/how-many-apples-can-you-put-into-the-basket/
     */
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int weight = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            weight += arr[i];
            if (weight > 5000) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }
}
