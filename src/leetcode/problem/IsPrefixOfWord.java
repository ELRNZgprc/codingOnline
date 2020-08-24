package leetcode.problem;

public class IsPrefixOfWord {
    /**
     * 1455. 检查单词是否为句中其他单词的前缀
     * https://leetcode-cn.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        int len = searchWord.length();
        for (int i = 0; i < strs.length; i++)
            if (strs[i].length() >= len && strs[i].substring(0, len).equals(searchWord))
                return i + 1;
        return -1;
    }
}
