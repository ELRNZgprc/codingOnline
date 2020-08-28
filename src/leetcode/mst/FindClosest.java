package leetcode.mst;

public class FindClosest {
    /**
     * 面试题 17.11. 单词距离
     * https://leetcode-cn.com/problems/find-closest-lcci/
     */
    public int findClosest(String[] words, String word1, String word2) {
        int start = -10000;
        int end = 20001;
        int min = end - start;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                start = i;
            }
            if (words[i].equals(word2)) {
                end = i;
            }
            min = Math.min(min, Math.abs(end - start));
        }
        return min;
    }
}
