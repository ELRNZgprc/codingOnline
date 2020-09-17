package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class CommonChars {
    /**
     * 1002. 查找常用字符
     * https://leetcode-cn.com/problems/find-common-characters/
     */
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            int min = Integer.MAX_VALUE;
            int s = 0;
            while ((min > 0) && (s < A.length)) {
                int count = A[s].length();
                count -= A[s].replaceAll(Character.toString(c), "").length();
                min = Math.min(min, count);
                s++;
            }
            for (int i = 0; i < min; i++) {
                ans.add(Character.toString(c));
            }
        }
        return ans;
    }
}
