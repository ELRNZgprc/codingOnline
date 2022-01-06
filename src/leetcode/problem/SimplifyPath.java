package leetcode.problem;

import java.util.Stack;

/**
 * 71. 简化路径
 * https://leetcode-cn.com/problems/simplify-path/
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : arr) {
            if (str.equals("..") && !stack.isEmpty()) stack.pop();
            if (!str.equals(".") && !str.equals("..") && !str.equals("")) stack.push(str);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}
