package leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2578. 最小和分割
 * https://leetcode.cn/problems/split-with-minimum-sum/
 */
public class SplitNum {
    public int splitNum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.sort(list);
        int n1 = list.get(0);
        int n2 = list.get(1);
        for (int i = 2; i < list.size(); i += 2) {
            n1 = n1 * 10 + list.get(i);
        }
        for (int i = 3; i < list.size(); i += 2) {
            n2 = n2 * 10 + list.get(i);
        }
        return n1 + n2;
    }
}
