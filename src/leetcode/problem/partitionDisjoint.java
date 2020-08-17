package leetcode.problem;

public class partitionDisjoint {
    /**
     * 915
     * https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals/
     */
    public int partitionDisjoint(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int length = A.length;
        int[] leftMax = new int[length];
        int[] rightMin = new int[length];

        leftMax[0] = A[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A[i]);
        }

        rightMin[length - 1] = A[length - 1];

        for (int i = length - 2; i > -1; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], A[i]);
        }

        int ans = 0;
        while (leftMax[ans] > rightMin[ans + 1]) {
            ans++;
        }
        return ans + 1;
    }
}
