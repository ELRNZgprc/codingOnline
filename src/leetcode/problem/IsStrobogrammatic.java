package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

public class IsStrobogrammatic {
    /**
     * 246. 中心对称数
     * https://leetcode-cn.com/problems/strobogrammatic-number/
     */
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(map.get(c));
            } else {
                return false;
            }
        }
        return sb.reverse().toString().equals(num);
    }
}
