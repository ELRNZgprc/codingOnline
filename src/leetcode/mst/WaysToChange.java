package leetcode.mst;

public class WaysToChange {
    /**
	 * 面试题 08.11. 硬币
     * https://leetcode-cn.com/problems/coin-lcci/
     */
    public int waysToChange(int n) {
        int[] memory = new int[n + 1];
        int[] icons = {25, 10, 5, 1};
        memory[0] = 1;
        for (int icon :
                icons) {
            for (int i = 1; i <= n; i++) {
                if (i - icon >= 0) {
                    memory[i] = (memory[i] + memory[i - icon]) % 1000000007;
                }
            }
        }
        return memory[n];
    }
}
