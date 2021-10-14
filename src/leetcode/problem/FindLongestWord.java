package leetcode.problem;

import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String d : dictionary) {
            int j = 0;
            int i = 0;
            while ((j < d.length()) && (i < s.length())) {
                if (s.charAt(i) == d.charAt(j)) {
                    j++;
                }
                i++;
            }
            if (j == d.length()) {
                if ((d.length() > ans.length()) || ((d.length() == ans.length()) && (d.compareTo(ans) < 0))) {
                    ans = d;
                }
            }
        }
        return ans;
    }
}
