package leetcode.problem;

/**
 * 1313. 解压缩编码列表
 * https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
 */
public class DecompressRLElist {
    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i += 2) {
            length += nums[i];
        }
        int[] ans = new int[length];
        int start = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                ans[start] = nums[i + 1];
                start++;
            }
        }
        return ans;
    }
}
