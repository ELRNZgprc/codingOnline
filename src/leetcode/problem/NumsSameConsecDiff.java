package leetcode.problem;

import java.util.ArrayList;

/**
 * 967. 连续差相同的数字
 * https://leetcode.cn/problems/numbers-with-same-consecutive-differences/
 */
public class NumsSameConsecDiff {
    ArrayList<Integer> al = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        for (int i = 1; i < 10; i++) {
            dfs(n, k, i, 1);
        }
        int[] ans = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ans[i] = al.get(i);
        }
        return ans;
    }

    public void dfs(int n, int k, int num, int length) {
        if (length == n) {
            al.add(num);
        } else {
            int last = num % 10;
            if (last + k < 10) {
                dfs(n, k, num * 10 + last + k, length + 1);
            }
            if ((k != 0) && (last - k >= 0)) {
                dfs(n, k, num * 10 + last - k, length + 1);
            }
        }
    }
}
