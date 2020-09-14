package leetcode.problem;

import java.util.List;

public class MaxLength {
    /**
     * 1239. 串联字符串的最大长度
     * https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
     */
    boolean[] flag = new boolean[26];
    int ans = 0;

    public int maxLength(List<String> arr) {
        work(arr, 0);
        return ans;
    }

    void work(List<String> arr, int n) {
        for (int i = n; i < arr.size(); i++) {
            if (isOK(arr.get(i))) {
                add(arr.get(i));
                work(arr, i + 1);
                delete(arr.get(i));
            }
        }
    }

    boolean isOK(String s) {

        for (char c : s.toCharArray()) {
            if ((flag[c - 'a']) || (s.lastIndexOf(c) != s.indexOf(c))) {
                return false;
            }
        }
        return true;
    }

    void add(String s) {
        for (char c : s.toCharArray()) {
            flag[c - 'a'] = true;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (flag[i]) {
                sum++;
            }
        }
        ans = Math.max(sum, ans);
    }

    void delete(String s) {
        for (char c : s.toCharArray()) {
            flag[c - 'a'] = false;
        }
    }
}
