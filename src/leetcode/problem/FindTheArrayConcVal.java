package leetcode.problem;

/**
 * 2562. 找出数组的串联值
 * https://leetcode.cn/problems/find-the-array-concatenation-value/
 */
public class FindTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        long res = 0;
        while (left < right) {
            long l = (long) nums[left];
            long r = (long) nums[right];
            res += r;
            while (r > 0) {
                l *= 10;
                r /= 10;
            }
            res += l;
            left++;
            right--;
        }
        if (left == right) {
            res += nums[left];
        }
        return res;
    }
}
