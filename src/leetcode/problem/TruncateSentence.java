package leetcode.problem;

/**
 * 1816. 截断句子
 * https://leetcode-cn.com/problems/truncate-sentence/
 */
public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ' && --k == 0)
                return s.substring(0, i);
        return s;
    }
}
