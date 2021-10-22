package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1198. 找出所有行中最小公共元素
 * https://leetcode-cn.com/problems/find-smallest-common-element-in-all-rows/
 */
public class SmallestCommonElement {
    public int smallestCommonElement(int[][] mat) {
        List<Integer> candidate = new ArrayList<>();
        for (int num : mat[0]) {
            candidate.add(num);
        }
        List<Integer> newCandidate = new ArrayList<>();
        for (int i = 1; i < mat.length; i++) {
            for (int num : mat[i]) {
                if (candidate.contains(num)) {
                    newCandidate.add(num);
                }
            }
            if (newCandidate.isEmpty()) {
                return -1;
            }
            candidate.clear();
            candidate.addAll(newCandidate);
            newCandidate.clear();
        }
        return candidate.get(0);
    }
}
