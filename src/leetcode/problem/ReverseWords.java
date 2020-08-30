package leetcode.problem;

public class ReverseWords {
    /**
     * 557. 反转字符串中的单词 III
     * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
     */
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(new StringBuilder(str).reverse());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
