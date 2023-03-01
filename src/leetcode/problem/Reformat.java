package leetcode.problem;

import java.util.Stack;

/**
 * 1417. 重新格式化字符串
 * https://leetcode.cn/problems/reformat-the-string/
 */
public class Reformat {
    public String reformat(String s) {
        Stack<Character> chars = new Stack<>();
        Stack<Character> nums = new Stack<>();
        for (char c : s.toCharArray()) {
            if ((c >= 'a') && (c <= 'z')) {
                chars.add(c);
            } else if ((c >= '0') && (c <= '9')) {
                nums.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (Math.abs(chars.size() - nums.size()) > 1) {
            return sb.toString();
        }
        if (chars.size() >= nums.size()) {
            while (!nums.empty()) {
                sb.append(chars.pop());
                sb.append(nums.pop());
            }
            if (!chars.empty()) {
                sb.append(chars.pop());
            }
            return sb.toString();
        }
        while (!chars.empty()) {
            sb.append(nums.pop());
            sb.append(chars.pop());
        }
        if (!nums.empty()) {
            sb.append(nums.pop());
        }
        return sb.toString();
    }
}
