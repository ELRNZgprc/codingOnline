package leetcode.offer;

public class exchange {
    /**
     * offer 21
     * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
     */
    public int[] exchange(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[right] = num;
                right--;
            } else {
                ans[left] = num;
                left++;
            }
        }
        return ans;
    }
}
