package leetcode.problem;

import java.util.Arrays;

public class largestNumber {
    /**
     * 179
     * https://leetcode-cn.com/problems/largest-number/
     */
    public String largestNumber(int[] nums) {
        if (nums.length < 1) {
            return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder ans = new StringBuilder();

        for (String s : str) {
            ans.append(s);
        }

        String result = ans.toString();

        if (result.charAt(0) == '0') {
            return "0";
        }

        return result;
    }
}
