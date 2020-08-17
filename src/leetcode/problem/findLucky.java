package leetcode.problem;

public class findLucky {
    /**
     * 1394
     * https://leetcode-cn.com/problems/find-lucky-integer-in-an-array/
     */
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int i : arr) {
            count[i]++;
        }
        int ans = -1;
        for (int i = 1; i < 501; i++) {
            if (count[i] == i) {
                ans = i;
            }
        }
        return ans;
    }
}
