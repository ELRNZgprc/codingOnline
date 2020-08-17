package leetcode.problem;

public class minAddToMakeValid {
    /**
     * 921
     * https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid/
     */
    public int minAddToMakeValid(String S) {
        int left = 0;
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    ans++;
                }
            }
        }
        ans += left;
        return ans;
    }
}
