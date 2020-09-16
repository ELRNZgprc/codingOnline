package leetcode.problem;

import java.util.*;

public class ValidateBinaryTreeNodes {
    /**
     * 1361. 验证二叉树
     * https://leetcode-cn.com/problems/validate-binary-tree-nodes/
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n == 1) {
            return true;
        }
        int[] haveRoot = new int[n];
        Arrays.fill(haveRoot, -1);

        for (int i = 0; i < n; i++) {
            if ((leftChild[i] != -1) || (rightChild[i] != -1)) {
                if (haveRoot[i] == -1) {
                    haveRoot[i] = i;
                }
                List<Integer> jj = new ArrayList<>();
                if (leftChild[i] != -1) {
                    jj.add(leftChild[i]);
                }
                if (rightChild[i] != -1) {
                    jj.add(rightChild[i]);
                }
                for (int j : jj) {
                    if ((haveRoot[j] != -1) || (haveRoot[j] != j)) {
                        return false;
                    }
                    if ((haveRoot[i] == j) || (haveRoot[i] == haveRoot[j])) {
                        return false;
                    }
                    if (haveRoot[j] == j) {
                        for (int ii = 0; ii < n; ii++) {
                            if (haveRoot[ii] == j) {
                                haveRoot[ii] = haveRoot[i];
                            }
                        }
                    }
                    haveRoot[j] = haveRoot[i];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (haveRoot[i] != haveRoot[0]) {
                return false;
            }
        }
        return true;
    }
}
