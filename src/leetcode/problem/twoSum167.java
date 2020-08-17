package leetcode.problem;

public class twoSum167 {
    /**
     * 167
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                ans[0] = left;
                ans[1] = right;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else
                left++;
        }
        return ans;
    }
}
