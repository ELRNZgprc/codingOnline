package leetcode.problem;

public class nextGreatestLetter {
    /**
     * 744
     * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
     */
    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int ans = 0;
        while (letters[ans] <= target) {
            ans++;
        }
        return letters[ans];
    }
}
