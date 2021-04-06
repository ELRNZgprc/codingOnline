package leetcode.mst;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 */
public class CheckPermutation {
    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
