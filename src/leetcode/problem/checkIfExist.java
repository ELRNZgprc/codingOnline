package leetcode.problem;

public class checkIfExist {
    /**
     * 1346
     * https://leetcode-cn.com/problems/check-if-n-and-its-double-exist/
     */
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[j] == 2 * arr[i]) || (arr[i] == 2 * arr[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
