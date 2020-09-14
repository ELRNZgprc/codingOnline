package leetcode.problem;

public class FindLucky {
    /**
     * 1394. 找出数组中的幸运数
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
