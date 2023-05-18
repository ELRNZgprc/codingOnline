package leetcode.problem;

import java.util.ArrayDeque;

/**
 * 1073. 负二进制数相加
 * https://leetcode.cn/problems/adding-two-negabinary-numbers/
 */
public class AddNegabinary {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = n1 - 1, j = n2 - 1, add = 0; i >= 0 || j >= 0 || add != 0; i--, j--) {
            int cur = (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0) + add;
            if (cur == 0 || cur == 1) {
                add = 0;
                q.addFirst(cur);
            } else if (cur == 2) {
                add = -1;
                q.addFirst(0);
            } else if (cur == -1) {
                add = 1;
                q.addFirst(1);
            } else if (cur == 3) {
                add = -1;
                q.addFirst(1);
            }
        }
        while (q.size() > 1 && q.peek() == 0) q.pollFirst();
        int sz = q.size();
        int[] res = new int[sz];
        for (int i = 0; i < sz; i++) {
            res[i] = q.pollFirst();
        }
        return res;
    }
}
