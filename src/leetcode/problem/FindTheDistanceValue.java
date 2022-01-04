package leetcode.problem;

/**
 * 1385. 两个数组间的距离值
 * https://leetcode-cn.com/problems/find-the-distance-value-between-two-arrays/
 */
public class FindTheDistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = arr1.length;
        for (int a : arr1) {
            for (int b : arr2) {
                if (Math.abs(a - b) <= d) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
