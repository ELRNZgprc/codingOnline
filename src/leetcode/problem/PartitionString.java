package leetcode.problem;

/**
 * 2405. 子字符串的最优划分
 * https://leetcode.cn/problems/optimal-partition-of-string/
 */
public class PartitionString {
    public int partitionString(String s) {
        int ans = 1;
        boolean[] hash = new boolean[26];
        char[] cc = s.toCharArray();
        for (char c : cc) {
            if (hash[c - 'a']) {
                ans++;
                for (int i = 0; i < 26; i++) {
                    hash[i] = false;
                }
            }
            hash[c - 'a'] = true;
        }
        return ans;
    }
}
