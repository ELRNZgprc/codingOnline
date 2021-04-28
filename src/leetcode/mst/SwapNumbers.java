package leetcode.mst;

/**
 * 面试题 16.01. 交换数字
 * https://leetcode-cn.com/problems/swap-numbers-lcci/
 */
public class SwapNumbers {
    public int[] swapNumbers(int[] numbers) {
        numbers[0]+=numbers[1];
        numbers[1]=numbers[0]-numbers[1];
        numbers[0]-=numbers[1];
        return numbers;
    }
}
