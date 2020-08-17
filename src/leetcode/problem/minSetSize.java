package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class minSetSize {
    /**
     * 1338
     * https://leetcode-cn.com/problems/reduce-array-size-to-the-half/
     */
    public int minSetSize(int[] arr) {
        Arrays.sort(arr);

        List<Integer> nums = new ArrayList<>();

        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                nums.add(count);
                count = 1;
            }
        }
        nums.add(count);

        Collections.sort(nums);
        int ans = 0;
        int size = 0;
        int i = nums.size() - 1;
        while (size < (arr.length / 2)) {
            ans++;
            size += nums.get(i);
            i--;
        }
        return ans;
    }
}
