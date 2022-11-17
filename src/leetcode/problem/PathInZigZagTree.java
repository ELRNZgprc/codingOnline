package leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1104. 二叉树寻路
 * https://leetcode.cn/problems/path-in-zigzag-labelled-binary-tree/
 */
public class PathInZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        res.add(label);
        int c = (int) (Math.log(label) / Math.log(2));
        while (c != 0) {
            label = (int) (Math.pow(2, c) - 1) + (int) (Math.pow(2, c - 1)) - label / 2;
            res.add(label);
            c--;
        }
        Collections.reverse(res);
        return res;
    }
}
