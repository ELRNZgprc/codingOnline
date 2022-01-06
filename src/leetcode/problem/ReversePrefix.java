package leetcode.problem;

/**
 * 2000. 反转单词前缀
 * https://leetcode-cn.com/problems/reverse-prefix-of-word/
 */
public class ReversePrefix {
    public String reversePrefix(String word, char ch) {
        int ind = word.indexOf(ch);
        StringBuilder s = new StringBuilder(word.substring(0, ind + 1));
        return s.reverse().append(word.substring(ind + 1)).toString();
    }
}
