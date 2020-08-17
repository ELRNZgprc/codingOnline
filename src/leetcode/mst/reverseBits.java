package leetcode.mst;

import java.util.ArrayList;
import java.util.List;

public class reverseBits {
    /**
     * 面试题 05.03
     * https://leetcode-cn.com/problems/reverse-bits-lcci/
     */
    public int reverseBits(int num) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                count++;
            } else {
                list.add(count);
                count = 0;
            }
            num /= 2;
        }
        list.add(count);
        if (list.size() == 1) {
            return list.get(0) + 1;
        }
        int ans = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            ans = Math.max(ans, list.get(i) + list.get(i + 1));
        }
        return ans + 1;
    }
}
