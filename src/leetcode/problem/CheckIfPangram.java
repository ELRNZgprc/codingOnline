package leetcode.problem;

/**
 * 1832. 判断句子是否为全字母句
 * https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram/
 */
public class CheckIfPangram {
    public boolean checkIfPangram(String sentence) {
        int[] array = new int[26];
        for (char c : sentence.toCharArray())
            array[c - 'a']++;
        for (int i : array)
            if (i == 0)
                return false;
        return true;
    }
}
