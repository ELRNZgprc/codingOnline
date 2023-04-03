package leetcode.problem;

/**
 * 1053. 交换一次的先前排列
 * https://leetcode.cn/problems/previous-permutation-with-one-swap/
 */
public class PrevPermOpt1 {
    public int[] prevPermOpt1(int[] arr) {
        int left = arr.length - 1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                left = i - 1;
                break;
            }
        }

        for (int i = arr.length - 1; i > left; i--) {
            if (arr[i] == arr[i - 1]) continue;
            if (arr[i] < arr[left]) {
                int tem = arr[i];
                arr[i] = arr[left];
                arr[left] = tem;
                break;
            }
        }
        return arr;
    }
}
