package leetcode.problem;

import java.util.HashSet;

public class UniqueMorseRepresentations {
    /**
     * 804. 唯一摩尔斯密码词
     * https://leetcode-cn.com/problems/unique-morse-code-words/
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> ans = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(code[c - 'a']);
            }
            ans.add(sb.toString());
        }
        return ans.size();
    }
}
