package leetcode.problem;

public class replaceElements {
    /**
     * 1299
     * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
     */
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int max = -1;
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }
}
