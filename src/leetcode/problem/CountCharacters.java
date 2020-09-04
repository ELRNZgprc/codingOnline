package leetcode.problem;

public class CountCharacters {
    /**
     * 1160. 拼写单词
     * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
     */
    int[] count;

    public int countCharacters(String[] words, String chars) {
        count = new int[26];
        int ans = 0;
        for (String word : words) {
            if (isOK(word, chars)) {
                ans += word.length();
            }
        }
        return ans;
    }

    boolean isOK(String word, String chars) {
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : word.toCharArray()) {
            if (count[c - 'a'] <= 0) {
                return false;
            } else {
                count[c - 'a']--;
            }
        }
        return true;
    }
}
