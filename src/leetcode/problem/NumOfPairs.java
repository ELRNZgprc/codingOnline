package leetcode.problem;

/**
 * 2023. 连接后等于目标字符串的字符串对
 * https://leetcode.cn/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
 */
public class NumOfPairs {
    public int numOfPairs(String[] nums, String target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]).equals(target)) {
                    ans++;
                }
                if ((nums[j] + nums[i]).equals(target)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
