package leetcode.problem;

/**
 * 2114. 句子中的最多单词数
 * https://leetcode.cn/problems/maximum-number-of-words-found-in-sentences/
 */
public class MostWordsFound {
    public int mostWordsFound(String[] sentences) {
        int max=0;
        for (String sentence : sentences) {
            int j = sentence.split(" ").length;
            max = Math.max(max, j);
        }
        return max;
    }
}
